package com.vigade.pizzeriabackend.domain.ingredientDomain;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;
import com.vigade.pizzeriabackend.core.baseClasses.EntityBase;

@Table("ingredients")
public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase {

    @Column("name")
    private String name;

    @Column("price")
    private BigDecimal price;
}