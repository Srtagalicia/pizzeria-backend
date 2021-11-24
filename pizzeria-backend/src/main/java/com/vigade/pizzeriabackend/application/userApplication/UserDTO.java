package com.vigade.pizzeriabackend.application.userApplication;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.userDomain.Role;
import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserDTO {
    private UUID id;

    private String name;

    private String surname;

    private String email;

    private String token;

    private String type;
	
    private Role role;
}