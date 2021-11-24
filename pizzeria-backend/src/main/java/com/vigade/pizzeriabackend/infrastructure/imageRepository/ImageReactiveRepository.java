package com.vigade.pizzeriabackend.infrastructure.imageRepository;

import com.vigade.pizzeriabackend.domain.imageDomain.Image;

import reactor.core.publisher.Mono;

public interface ImageReactiveRepository {
    public Mono<Image> add(Image image);
}
