package com.ahumadamob.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Generic DTO for API responses.
 * @param <T> type of the data payload
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    private String message;
    private T data;
    private LocalDateTime timestamp;
    private Map<String, Object> metadata;
}
