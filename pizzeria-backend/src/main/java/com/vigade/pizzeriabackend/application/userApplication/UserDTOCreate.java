package com.vigade.pizzeriabackend.application.userApplication;

import com.vigade.pizzeriabackend.domain.userDomain.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter class UserDTOCreate {
    private String name;

    private String surname;

    private String email;

    private String passw;

    private Role role;
}