package com.vigade.pizzeriabackend.application.userApplication;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserDTOOutput {
    private String token;
    private String type;
    private String expired = "3600";
    private String refreshToken;
}