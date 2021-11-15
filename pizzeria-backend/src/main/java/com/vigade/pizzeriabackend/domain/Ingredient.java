package com.vigade.pizzeriabackend.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Ingredients")
public class Ingredient {
    @Id
    @Column(
        name="id",
        updatable=false,
        nullable=false
    )
    private UUID id = UUID.randomUUID();
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private float price;
}
