package com.vigade.pizzeriabackend.application.userApplication;

import reactor.core.publisher.Mono;

public interface UserApplication {
    public Mono<UserDTOOutput> add(UserDTOCreate dto);
}