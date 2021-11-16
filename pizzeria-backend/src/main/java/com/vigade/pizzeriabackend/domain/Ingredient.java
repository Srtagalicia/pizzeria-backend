package com.vigade.pizzeriabackend.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Ingredients")
@Getter @Setter
public class Ingredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
        name = "id",
        updatable = false,
        nullable = false,
        columnDefinition = "varbinary(16)"
    )
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private float price;
}
