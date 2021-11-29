package com.vigade.pizzeriabackend.application.imageAplication;

import java.util.UUID;

import com.vigade.pizzeriabackend.core.baseClasses.ApplicationBase;
import com.vigade.pizzeriabackend.domain.imageDomain.Image;
import com.vigade.pizzeriabackend.infrastructure.imageRepository.ImageReactiveRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class ImageApplicationImpl extends ApplicationBase<Image, UUID> implements ImageApplication {
    private final ImageReactiveRepository imageRepository;
    private final ModelMapper modelMapper;
    private final Logger logger;

    @Autowired
    public ImageApplicationImpl(final ImageReactiveRepository imageRepository, final ModelMapper modelMapper, final Logger logger) {
        super((id) -> imageRepository.getImageRedis(id));
        this.imageRepository = imageRepository;
        this.modelMapper = modelMapper;
        this.logger = logger;
    }
//TODO: te deja añadir imagenes sin data
    public Mono<ImageDTO> add(ImageDTOInput dto) {
        Image image = modelMapper.map(dto, Image.class);
        image.setId(UUID.randomUUID());
        image.setThisNew(true);
        this.logger.info(serializeObject(image, "Image Added"));
        return this.imageRepository.add(image)
                .flatMap(monoImage -> Mono.just(this.modelMapper.map(monoImage, ImageDTO.class)));
    }

    public Mono<ImageDTO> getImageRedis(UUID id){
        return this.imageRepository.getImageRedis(id).map(monoImage -> this.modelMapper.map(monoImage, ImageDTO.class));
      }
}
