package com.vigade.pizzeriabackend.application.imageAplication;

import java.util.UUID;
import reactor.core.publisher.Mono;

public interface ImageApplication {
    public Mono<ImageDTO> add(ImageDTOInput dto);
    public Mono<ImageDTO> getImageRedis(UUID id);
}