package com.vigade.pizzeriabackend.domain.userDomain;

import java.util.UUID;
import com.vigade.pizzeriabackend.core.functionalInterfaces.FindById;
import com.vigade.pizzeriabackend.core.functionalInterfaces.ExistsByField;
import reactor.core.publisher.Mono;

public interface UserRepository extends FindById<User, UUID>, ExistsByField{
    public Mono<User> add(User user);
}