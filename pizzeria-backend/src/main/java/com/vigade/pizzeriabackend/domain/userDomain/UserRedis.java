package com.vigade.pizzeriabackend.domain.userDomain;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter class UserRedis {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String accessToken;
    private String refreshToken;
}