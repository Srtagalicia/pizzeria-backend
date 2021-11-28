package com.vigade.pizzeriabackend.application.imageAplication;

import reactor.core.publisher.Mono;

public interface ImageApplication {
    public Mono<ImageDTO> add(ImageDTOInput dto);

}