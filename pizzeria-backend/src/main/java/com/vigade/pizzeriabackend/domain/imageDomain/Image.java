package com.vigade.pizzeriabackend.domain.imageDomain;

import com.vigade.pizzeriabackend.core.baseClasses.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter class Image extends EntityBase {
    private byte[] data;
}