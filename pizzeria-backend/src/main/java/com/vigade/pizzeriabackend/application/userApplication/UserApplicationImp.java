package com.vigade.pizzeriabackend.application.userApplication;

import java.util.UUID;
import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.vigade.pizzeriabackend.core.baseClasses.ApplicationBase;
import com.vigade.pizzeriabackend.domain.userDomain.User;
import com.vigade.pizzeriabackend.domain.userDomain.UserRedis;
import com.vigade.pizzeriabackend.domain.userDomain.UserRepository;
import com.vigade.pizzeriabackend.domain.userDomain.UserRepositoryRedis;
import com.vigade.pizzeriabackend.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserApplicationImp extends ApplicationBase<User,UUID> implements UserApplication {

    private UserRepository userRepository;
    private UserRepositoryRedis userRepositoryRedis;
    private ModelMapper modelMapper;
    private Logger logger;

    @Autowired
    public UserApplicationImp(
        UserRepository userRepository,
        UserRepositoryRedis userRepositoryRedis,
        ModelMapper modelMapper,
        Logger logger
    ) {
        super(id -> userRepository.findById(id));
        this.userRepository = userRepository;
        this.userRepositoryRedis = userRepositoryRedis;
        this.modelMapper = modelMapper;
        this.logger = logger;
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
        UserRedis userRedis = new UserRedis();
        userRedis.setId(user.getId().toString());
        userRedis.setFirstName(user.getFirstName());
        userRedis.setLastName(user.getLastName());
        userRedis.setEmail(user.getEmail());
        userRedis.setRole(user.getRole().toString());
        userRedis.setAccessToken(userDTOOutput.getAccessToken());
        userRedis.setRefreshToken(userDTOOutput.getRefreshToken());
        return user.validate("email", user.getEmail(), email -> this.userRepository.existsByField(email))
            .then(this.userRepositoryRedis.add(userRedis))
            .then(this.userRepository.add(user)).flatMap(monoUser -> {
                logger.info(this.serializeObject(monoUser, "Added User"));
                return Mono.just(userDTOOutput);
            });
    }
}