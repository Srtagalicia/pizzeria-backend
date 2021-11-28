package com.vigade.pizzeriabackend.application.imageAplication;

import java.util.UUID;

import com.vigade.pizzeriabackend.domain.imageDomain.Image;
import com.vigade.pizzeriabackend.infrastructure.imageRepository.ImageReactiveRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ImageApplicationImpl implements ImageApplication {
    private final ImageReactiveRepository imageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ImageApplicationImpl(final ImageReactiveRepository imageRepository, final ModelMapper modelMapper) {
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
    }

    public Mono<ImageDTO> add(ImageDTOInput dto) {
        Image image = modelMapper.map(dto, Image.class);
        image.setId(UUID.randomUUID());
        image.setThisNew(true);
        return this.imageRepository.add(image)
                .flatMap(monoImage -> Mono.just(this.modelMapper.map(monoImage, ImageDTO.class)));
    }
}
