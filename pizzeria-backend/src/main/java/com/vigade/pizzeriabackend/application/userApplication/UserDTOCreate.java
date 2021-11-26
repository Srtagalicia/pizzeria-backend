package com.vigade.pizzeriabackend.application.userApplication;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserDTOCreate {
    
    private String firstName;

    private String lastName;

    private String email;

    private String password;
}