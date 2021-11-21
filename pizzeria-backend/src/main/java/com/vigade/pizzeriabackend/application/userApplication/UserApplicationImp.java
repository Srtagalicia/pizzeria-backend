package com.vigade.pizzeriabackend.application.userApplication;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.userDomain.User;
import com.vigade.pizzeriabackend.domain.userDomain.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserApplicationImp implements UserApplication{ //TODO: extends ApplicationBase

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserApplicationImp (UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<UserDTO> add(UserDTOCreate dto) {
        User user  = modelMapper.map(dto, User.class);
        user.setId(UUID.randomUUID());
        user.setPassw(BCrypt.hashpw(user.getPassw(), BCrypt.gensalt()));
        user.setThisNew(true);
        //TODO: validate email

        return this.userRepository.add(user).flatMap(dbUser -> {
            return Mono.just(modelMapper.map(dbUser, UserDTO.class));
        });
    }
}