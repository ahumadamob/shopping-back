package com.ahumadamob.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * DTO used to wrap successful API responses.
 * @param <T> type of the data payload
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiSuccessResponseDto<T> {

    private String message;
    private T data;
    private LocalDateTime timestamp;
    private Map<String, Object> metadata;
}
