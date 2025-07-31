package com.ahumadamob.common;

import com.ahumadamob.dto.ApiSuccessResponseDto;
import com.ahumadamob.dto.CategoriaResponseDto;
import com.ahumadamob.dto.ProductoResponseDto;
import com.ahumadamob.dto.PictureResponseDto;
import org.springframework.http.HttpStatus;
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

    /**
     * Wraps the given data in an {@link ApiSuccessResponseDto} and returns a 201 CREATED response.
     *
     * @param data the payload to include in the response
     * @param <T>  the payload type
     * @return ResponseEntity containing the standardized created DTO
     */
    public static <T> ResponseEntity<ApiSuccessResponseDto<T>> created(T data) {
        ApiSuccessResponseDto<T> response = ApiSuccessResponseDto.<T>builder()
                .message("Created")
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Wraps the given data in an {@link ApiSuccessResponseDto} with an
     * "Updated" message and returns a 200 OK response.
     *
     * @param data the payload containing the updated resource
     * @return ResponseEntity containing the standardized updated DTO
     */
    public static ResponseEntity<ApiSuccessResponseDto<CategoriaResponseDto>> updated(
            CategoriaResponseDto data) {
        ApiSuccessResponseDto<CategoriaResponseDto> response = ApiSuccessResponseDto
                .<CategoriaResponseDto>builder()
                .message("Updated")
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    /**
     * Wraps the given data in an {@link ApiSuccessResponseDto} with an
     * "Updated" message and returns a 200 OK response.
     *
     * @param data the payload containing the updated resource
     * @return ResponseEntity containing the standardized updated DTO
     */
    public static ResponseEntity<ApiSuccessResponseDto<ProductoResponseDto>> updated(
            ProductoResponseDto data) {
        ApiSuccessResponseDto<ProductoResponseDto> response = ApiSuccessResponseDto
                .<ProductoResponseDto>builder()
                .message("Updated")
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    /**
     * Wraps the given data in an {@link ApiSuccessResponseDto} with an
     * "Updated" message and returns a 200 OK response.
     *
     * @param data the payload containing the updated resource
     * @return ResponseEntity containing the standardized updated DTO
     */
    public static ResponseEntity<ApiSuccessResponseDto<PictureResponseDto>> updated(
            PictureResponseDto data) {
        ApiSuccessResponseDto<PictureResponseDto> response = ApiSuccessResponseDto
                .<PictureResponseDto>builder()
                .message("Updated")
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    /**
     * Builds a "Deleted" response with no body and returns a 200 OK status.
     *
     * @return ResponseEntity containing the standardized deleted DTO
     */
    public static ResponseEntity<ApiSuccessResponseDto<Void>> deleted() {
        ApiSuccessResponseDto<Void> response = ApiSuccessResponseDto.<Void>builder()
                .message("Deleted")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
