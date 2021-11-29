package com.vigade.pizzeriabackend.domain.userDomain;

import org.springframework.data.relational.core.mapping.Table;
import com.vigade.pizzeriabackend.core.baseClasses.EntityBase;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.util.StringUtils;
import com.vigade.pizzeriabackend.core.exceptions.BadRequestException;

@Table("users")
public @NoArgsConstructor @Getter @Setter class User extends EntityBase {
    
    @Column("firstName")
    @NotBlank(message="firstName is mandatory") @Size(min=2, max=45)
    private String firstName;

    @Column("lastName")
    @NotBlank(message="lastName is mandatory") @Size(min=2, max=45)
    private String lastName;

    @Column("email")
    @NotBlank(message="email is mandatory") @Size(min=2, max=255) @Email
    private String email;

    @Column("password")
    @Size(max=255)
    private String password;
	
    @Column("role")
    @NotNull
    private Role role = Role.CUSTOMER;

    @Column("provider")
    @NotNull
    private Provider provider = Provider.LOGIN;

    @Column("retries")
    @NotNull @Min(value=0) @Max(value=3)
    private Integer retries = 0;

    @Column("state")
    @NotNull
    private State state = State.ACTIVE;

    @Override
    public void validate() {
        super.validate();
        if(this.provider == Provider.LOGIN && !StringUtils.hasText(this.password)) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.addException("password", "A password is required.");
            throw badRequestException;
        } else if(this.provider != Provider.LOGIN && StringUtils.hasText(this.password)) {
            BadRequestException badRequestException = new BadRequestException();
            badRequestException.addException("password", "Password field must be empty.");
            throw badRequestException;
        }
    }
}