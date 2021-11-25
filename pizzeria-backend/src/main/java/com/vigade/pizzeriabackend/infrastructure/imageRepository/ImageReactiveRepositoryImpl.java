package com.vigade.pizzeriabackend.infrastructure.imageRepository;

import java.time.Duration;
import com.vigade.pizzeriabackend.domain.imageDomain.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ImageReactiveRepositoryImpl implements ImageReactiveRepository {
    private final ReactiveRedisOperations<String, byte[]> redisOperations;

    @Autowired
    public ImageReactiveRepositoryImpl(final ReactiveRedisOperations<String, byte[]> redisOperations) {
        this.redisOperations = redisOperations;
    }

    public Mono<Image> add(Image image) {
        return redisOperations.opsForValue().set(image.getId().toString(), image.getData(), Duration.ofDays(1))
                .map(img -> image);
    }
}