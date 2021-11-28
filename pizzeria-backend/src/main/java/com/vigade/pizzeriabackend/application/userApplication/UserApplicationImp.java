package com.vigade.pizzeriabackend.application.userApplication;

import java.util.UUID;
import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.vigade.pizzeriabackend.core.baseClasses.ApplicationBase;
import com.vigade.pizzeriabackend.domain.userDomain.User;
import com.vigade.pizzeriabackend.domain.userDomain.UserRepository;
import com.vigade.pizzeriabackend.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserApplicationImp extends ApplicationBase<User,UUID> implements UserApplication {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserApplicationImp(UserRepository userRepository, ModelMapper modelMapper) {
        super(id -> userRepository.findById(id));
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<UserDTOOutput> add(UserDTOCreate userDTOCreate) {
        User user = this.modelMapper.map(userDTOCreate, User.class);
        user.setId(UUID.randomUUID());
        user.setThisNew(true);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        UserDTOOutput userDTOOutput = new UserDTOOutput();
        userDTOOutput.setAccessToken(JwtUtils.generatetJwtToken(user));
        userDTOOutput.setRefreshToken(NanoIdUtils.randomNanoId());
        return user.validate("email", user.getEmail(), email -> this.userRepository.existsByField(email))
            .then(this.userRepository.add(user)).then(Mono.just(userDTOOutput));
    }
}