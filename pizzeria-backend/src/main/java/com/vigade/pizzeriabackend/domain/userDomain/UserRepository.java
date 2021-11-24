package com.vigade.pizzeriabackend.domain.userDomain;

import java.util.UUID;
import com.vigade.pizzeriabackend.core.functionalInterfaces.FindById;
import reactor.core.publisher.Mono;

public interface UserRepository extends FindById<User, UUID>{
    Mono<User> add(User user);
}