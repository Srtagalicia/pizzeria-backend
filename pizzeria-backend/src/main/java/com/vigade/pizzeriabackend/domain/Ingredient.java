package com.vigade.pizzeriabackend.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.*;
@Table (("ingredients"))
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Getter
    @Setter
    @Id
    @Column("id")
    private int id;
    @Getter
    @Setter
    @Column("name")
    private String ingredientName;
    @Getter
    @Setter
    @Column("price")
    private float price;

    

}
