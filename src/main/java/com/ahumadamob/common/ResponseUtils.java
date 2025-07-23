package com.ahumadamob.common;

import com.ahumadamob.dto.ApiSuccessResponseDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

/**
 * Utility methods for building standardized successful responses.
 */
public abstract class ResponseUtils {

    private ResponseUtils() {
        // prevent instantiation
    }

    /**
     * Wraps the given data in an {@link ApiSuccessResponseDto} and returns a 200 OK response.
     *
     * @param data the payload to include in the response
     * @param <T>  the payload type
     * @return ResponseEntity containing the standardized success DTO
     */
    public static <T> ResponseEntity<ApiSuccessResponseDto<T>> ok(T data) {
        ApiSuccessResponseDto<T> response = ApiSuccessResponseDto.<T>builder()
                .message("Success")
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
