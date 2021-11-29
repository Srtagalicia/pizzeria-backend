package com.vigade.pizzeriabackend.infrastructure.imageRepository;

import java.util.UUID;

import com.vigade.pizzeriabackend.domain.imageDomain.Image;

import reactor.core.publisher.Mono;

public interface ImageReactiveRepository {
    public Mono<Image> add(Image image);
    public Mono<Image> getImageRedis(UUID uuid);
}
