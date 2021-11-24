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

    @Column("passw")
    private String passw;

    @Column("type")
    private String type;
	
    @Column("role")
    private Role role;
}