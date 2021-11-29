package com.vigade.pizzeriabackend.infrastructure.imageRepository;

import java.time.Duration;
import java.util.UUID;
import com.vigade.pizzeriabackend.domain.imageDomain.Image;
import com.vigade.pizzeriabackend.domain.imageDomain.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ImageRepositoryImpl implements ImageRepository {
    
    private final ReactiveRedisOperations<String, byte[]> redisOperations;

    @Autowired
    public ImageRepositoryImpl(final ReactiveRedisOperations<String, byte[]> redisOperations) {
        this.redisOperations = redisOperations;
    }

    @Override
    public Mono<Image> add(Image image) {
        return redisOperations.opsForValue().set(image.getId().toString(), image.getData(), Duration.ofDays(1))
                .map(img -> image);
    }

    @Override
    public Mono<Image> getImageRedis(UUID id){
        return redisOperations.opsForValue()
                              .get(id.toString())
                              .flatMap(imageBytes -> {
                                    Image image = new Image();
                                    image.setData(imageBytes);
                                    image.setId(id);
                                    return Mono.just(image);
                                }).
                                onErrorResume(err -> Mono.error(new Exception()));
    }
}