package com.ahumadamob.exception;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Long id) {
        super("Categoria not found with id " + id);
    }
}
