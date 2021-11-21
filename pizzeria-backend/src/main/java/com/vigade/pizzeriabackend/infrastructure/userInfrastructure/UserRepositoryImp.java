package com.vigade.pizzeriabackend.infrastructure.userInfrastructure;

import com.vigade.pizzeriabackend.domain.userDomain.User;
import com.vigade.pizzeriabackend.domain.userDomain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImp implements UserRepository{

    private UserReactiveRepository userReactiveRepository;

    @Autowired
    public UserRepositoryImp (UserReactiveRepository userReactiveRepository) {
        this.userReactiveRepository = userReactiveRepository;
    }

    @Override
    public Mono<User> add(User user) {
        return this.userReactiveRepository.save(user);
    }
}