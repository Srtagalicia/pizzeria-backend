package com.vigade.pizzeriabackend.application.imageAplication;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter class ImageDTO {
    public UUID id;
    public byte[] data;
}