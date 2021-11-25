package com.vigade.pizzeriabackend.domain.ingredientDomain;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;
import com.vigade.pizzeriabackend.core.baseClasses.EntityBase;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table("ingredients")
public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase {

    @Column("name")
    @NotBlank(message="name is mandatory") @Size(min=2, max=45)
    private String name;

    @Column("price")
    @NotNull(message="price is mandatory") @Digits(integer=3, fraction=2) @DecimalMin(value="0.0", inclusive=false)
    private BigDecimal price;
}