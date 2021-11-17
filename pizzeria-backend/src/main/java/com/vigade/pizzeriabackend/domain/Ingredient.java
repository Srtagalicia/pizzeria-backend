package com.vigade.pizzeriabackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("ingredients")
public class Ingredient {
    @Id
    @Column("id")
    private UUID id = UUID.randomUUID();
    @Column("name")
    private String name;
    @Column("price")
    private float price;
}
