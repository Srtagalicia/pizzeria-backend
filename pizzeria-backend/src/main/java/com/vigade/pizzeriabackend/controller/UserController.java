package com.vigade.pizzeriabackend.controller;

import com.vigade.pizzeriabackend.application.userApplication.UserApplication;
import com.vigade.pizzeriabackend.application.userApplication.UserDTO;
import com.vigade.pizzeriabackend.application.userApplication.UserDTOCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserApplication userApplication;

    @Autowired
    public UserController(UserApplication userApplication){
        this.userApplication = userApplication;
    }

    @PostMapping
    public Mono<ResponseEntity<UserDTO>> create(@RequestBody UserDTOCreate dto){
        Mono<UserDTO> userDTO = this.userApplication.add(dto);
        return userDTO.flatMap(user -> {
            return Mono.just(ResponseEntity.status(201).body(user));
        });
    }
}