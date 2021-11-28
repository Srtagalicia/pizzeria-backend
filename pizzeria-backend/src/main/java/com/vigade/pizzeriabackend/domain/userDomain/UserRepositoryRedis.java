package com.vigade.pizzeriabackend.domain.userDomain;

import reactor.core.publisher.Mono;

public interface UserRepositoryRedis {
    public Mono<Void> add(UserRedis userRedis);
}