package com.vigade.pizzeriabackend.controller;

import java.io.IOException;
import com.vigade.pizzeriabackend.application.imageAplication.CreateOrUpdateImageDTO;
import com.vigade.pizzeriabackend.application.imageAplication.ImageApplication;
import com.vigade.pizzeriabackend.application.imageAplication.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public void upload(@RequestParam("image") MultipartFile file) throws IOException {
        //CreateOrUpdateImageDTO createOrUpdateImageDTO = new CreateOrUpdateImageDTO();
        //createOrUpdateImageDTO.setData(file.getBytes());
        //return imageApplication.add(createOrUpdateImageDTO);
       
    }
   
}
