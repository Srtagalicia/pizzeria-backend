package com.vigade.pizzeriabackend.application;

public interface Add<I,O> {
    public O add(I entity);
}