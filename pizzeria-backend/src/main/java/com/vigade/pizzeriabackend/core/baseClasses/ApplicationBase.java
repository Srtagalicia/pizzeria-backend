package com.vigade.pizzeriabackend.core.baseClasses;

import com.vigade.pizzeriabackend.core.exceptions.NotFoundException;
import com.vigade.pizzeriabackend.core.functionalInterfaces.FindById;
import reactor.core.publisher.Mono;

public abstract class ApplicationBase<T,ID> {
    
    protected FindById<T,ID> getById;

    protected ApplicationBase(FindById<T,ID> getById) {
        this.getById = getById;
    }

    protected Mono<T> getById(ID id) {
        return this.getById.findById(id).switchIfEmpty(Mono.error(new NotFoundException()));
    }
}