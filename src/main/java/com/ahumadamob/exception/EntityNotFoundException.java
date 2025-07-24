package com.ahumadamob.exception;

/**
 * Generic exception thrown when an entity is not found by id.
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entity, Object id) {
        super(String.format("%s not found with id %s", entity, id));
    }
}
