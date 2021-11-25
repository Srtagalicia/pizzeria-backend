package com.vigade.pizzeriabackend.application.userApplication;

import reactor.core.publisher.Mono;

public interface UserApplication {
    Mono<UserDTOOutput> add(UserDTOCreate dto);
}