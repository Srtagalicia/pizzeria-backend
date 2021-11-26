package com.vigade.pizzeriabackend.controller;

import com.vigade.pizzeriabackend.application.userApplication.UserApplication;
import com.vigade.pizzeriabackend.application.userApplication.UserDTOCreate;
import com.vigade.pizzeriabackend.application.userApplication.UserDTOOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserApplication userApplication;

    @Autowired
    public UserController(UserApplication userApplication){
        this.userApplication = userApplication;
    }

    @PostMapping("/register/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserDTOOutput> addCustomer(@RequestBody UserDTOCreate userDTOCreate){
        return this.userApplication.add(userDTOCreate);
    }
}