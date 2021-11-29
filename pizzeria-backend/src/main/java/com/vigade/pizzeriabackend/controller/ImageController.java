package com.vigade.pizzeriabackend.controller;

import java.io.IOException;
import java.util.UUID;

import com.vigade.pizzeriabackend.application.imageAplication.ImageApplication;
import com.vigade.pizzeriabackend.application.imageAplication.ImageDTO;
import com.vigade.pizzeriabackend.application.imageAplication.ImageDTOInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/images")
public class ImageController {

    public final ImageApplication imageApplication;

    @Autowired
    public ImageController(final ImageApplication imageApplication) {
        this.imageApplication = imageApplication;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ImageDTO> upload(@RequestParam("image") MultipartFile file) throws IOException {
        ImageDTOInput createOrUpdateImageDTO = new ImageDTOInput();
        createOrUpdateImageDTO.setData(file.getBytes());
        return imageApplication.add(createOrUpdateImageDTO);
       
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public Mono<ResponseEntity<ImageDTO>> getImage(@PathVariable UUID id) {
        return this.imageApplication.getImageRedis(id).map(image -> ResponseEntity.ok(image)).defaultIfEmpty(ResponseEntity.notFound().build());
    }
   
}
