package com.vigade.pizzeriabackend.domain.imageDomain;

import com.vigade.pizzeriabackend.core.baseClasses.EntityBase;

import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Image extends EntityBase {

    @Column
    private byte[] data;

}
