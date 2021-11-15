package com.vigade.pizzeriabackend.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String name;
    private float price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
