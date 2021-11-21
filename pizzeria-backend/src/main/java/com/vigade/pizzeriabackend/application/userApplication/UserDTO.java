package com.vigade.pizzeriabackend.application.userApplication;

import java.util.UUID;
import com.vigade.pizzeriabackend.domain.userDomain.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter class UserDTO {
    private UUID id;

    private String name;

    private String surname;

    private String email;

    private String passw;

    private String type;
	
    private Role role;
}