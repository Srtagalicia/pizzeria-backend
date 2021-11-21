package com.vigade.pizzeriabackend.application.userApplication;

import reactor.core.publisher.Mono;

public interface UserApplication {
    Mono<UserDTO> add(UserDTOCreate dto);
}