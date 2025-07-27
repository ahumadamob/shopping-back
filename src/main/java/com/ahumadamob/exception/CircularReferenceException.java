package com.ahumadamob.exception;

/**
 * Thrown when a category's parent would create a circular reference.
 */
public class CircularReferenceException extends RuntimeException {

    public CircularReferenceException(String message) {
        super(message);
    }
}
