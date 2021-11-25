package com.vigade.pizzeriabackend.core.functionalInterfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ExistsByField {
    public Mono<Boolean> existsByField(String field);
}