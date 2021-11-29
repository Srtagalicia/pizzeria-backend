package com.vigade.pizzeriabackend.application.userApplication;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
public @Getter @Setter class UserDTOCreate {
    
    @NotBlank(message="firstName is mandatory") @Size(min=2, max=45)
    private String firstName;

    @NotBlank(message="lastName is mandatory") @Size(min=2, max=45)
    private String lastName;

    @NotBlank(message="email is mandatory") @Size(min=2, max=255) @Email
    private String email;

    @NotBlank(message="password is mandatory") @Size(max=255)
    private String password;
}