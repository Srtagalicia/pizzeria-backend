package com.vigade.pizzeriabackend.application.userApplication;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserDTOOutput {
    private String type = "Bearer";
    private String accessToken;
    private Integer expiresSeconds = 3600;
    private String refreshToken;
}