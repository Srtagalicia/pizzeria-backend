package com.vigade.pizzeriabackend.domain.userDomain;

import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> add(User user);
}