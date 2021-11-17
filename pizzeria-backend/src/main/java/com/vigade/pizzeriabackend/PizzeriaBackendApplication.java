package com.vigade.pizzeriabackend;

import com.vigade.pizzeriabackend.mysql.IngredientRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class PizzeriaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaBackendApplication.class, args);
		System.out.println("hola spring");
	}

	@Bean
	ApplicationRunner run(IngredientRepository repository) {
		return args -> repository.findAll().subscribe(log::info);

	}
}
