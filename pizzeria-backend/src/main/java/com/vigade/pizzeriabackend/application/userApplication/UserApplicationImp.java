package com.vigade.pizzeriabackend.application.userApplication;

import java.util.UUID;

import com.vigade.pizzeriabackend.core.baseClasses.ApplicationBase;
import com.vigade.pizzeriabackend.domain.userDomain.User;
import com.vigade.pizzeriabackend.domain.userDomain.UserRepository;
import com.vigade.pizzeriabackend.application.userApplication.security.JwtUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserApplicationImp extends ApplicationBase<User, UUID> implements UserApplication{

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserApplicationImp (UserRepository userRepository, ModelMapper modelMapper) {
        super(id -> userRepository.findById(id));
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<UserDTOOutput> add(UserDTOCreate dto) {
        User user  = this.modelMapper.map(dto, User.class);
        user.setId(UUID.randomUUID());
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setThisNew(true);
        //TODO: validate email
        
        UserDTOOutput userDTO = this.modelMapper.map(user, UserDTOOutput.class);
        userDTO.setType("Bearer");
        userDTO.setToken(JwtUtils.generatetJwtToken(user));

        return this.userRepository.add(user).then(Mono.just(userDTO));
    }
}