package com.vigade.pizzeriabackend.infrastructure.userInfrastructure;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.userDomain.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

public interface UserReactiveRepository extends ReactiveCrudRepository<User, UUID> {
    
    @Query("SELECT CASE WHEN COUNT(email)>0 THEN true ELSE false END FROM users WHERE email = :email;")
    @Transactional(readOnly = true)
    public Mono<Integer> existsByEmail(@Param(value="email") String email);
}