package com.vigade.pizzeriabackend.application.userApplication;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserDTOCreate {
    private String name;

    private String surname;

    private String email;

    private String passw;
}