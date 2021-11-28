package com.vigade.pizzeriabackend.infrastructure.userInfrastructure;

import java.time.Duration;
import com.vigade.pizzeriabackend.domain.userDomain.UserRedis;
import com.vigade.pizzeriabackend.domain.userDomain.UserRepositoryRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryRedisImp implements UserRepositoryRedis {
    
    private ReactiveRedisOperations<String, UserRedis> reactiveRedisOperations;

    @Autowired
    public UserRepositoryRedisImp (ReactiveRedisOperations<String, UserRedis> reactiveRedisOperations) {
        this.reactiveRedisOperations = reactiveRedisOperations;
    }

    @Override
    public Mono<Void> add(UserRedis userRedis) {
        return this.reactiveRedisOperations.opsForValue().set(userRedis.getId(), userRedis, Duration.ofHours(10))
            .then(this.reactiveRedisOperations.opsForValue().set(userRedis.getRefreshToken(), userRedis, Duration.ofHours(10)))
            .then(Mono.empty());
    }
}