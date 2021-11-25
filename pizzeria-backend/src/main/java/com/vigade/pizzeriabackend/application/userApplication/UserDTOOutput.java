package com.vigade.pizzeriabackend.application.userApplication;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserDTOOutput {

    private String name;

    private String surname;

    private String email;

    private String token;

    private String type;

    private String expirer = "36000000";
}