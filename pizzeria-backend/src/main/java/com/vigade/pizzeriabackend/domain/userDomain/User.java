package com.vigade.pizzeriabackend.domain.userDomain;

import org.springframework.data.relational.core.mapping.Table;
import com.vigade.pizzeriabackend.core.baseClasses.EntityBase;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Table("users")
public @NoArgsConstructor @Getter @Setter class User extends EntityBase {
    @Column("name")
    private String name;

    @Column("surname")
    private String surname;

    @Column("email")
    private String email;

    @Column("password")
    private String password;
	
    @Column("role")
    private Role role = Role.CUSTOMER;

    @Column("provider")
    private Provider provider = Provider.LOGIN;

    @Column("retries")
    private Integer retries = 0;

    @Column("state")
    private State state = State.ACTIVE;


}