package com.vigade.pizzeriabackend.core.functionalInterfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindById<T,ID> {
    public Mono<T> findById(ID id);
}