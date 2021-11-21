package com.vigade.pizzeriabackend.infrastructure.userInfrastructure;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.userDomain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserReactiveRepository extends ReactiveCrudRepository<User, UUID> {
    
}