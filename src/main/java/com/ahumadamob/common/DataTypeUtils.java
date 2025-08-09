package com.ahumadamob.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/** Utility methods for converting and validating values based on {@link DataType}. */
public final class DataTypeUtils {

    private DataTypeUtils() {
    }

    /**
     * Parses the given textual value according to the provided {@link DataType}.
     *
     * @param valor the raw value as text
     * @param dataType the expected data type
     * @return the value converted to the corresponding Java type
     * @throws IllegalArgumentException if the value is invalid for the specified type
     */
    public static Object parse(String valor, DataType dataType) {
        if (valor == null) {
            throw new IllegalArgumentException("El valor no puede ser nulo");
        }
        return switch (dataType) {
            case TEXT -> {
                if (valor.isBlank()) {
                    throw new IllegalArgumentException("El valor de texto no puede estar vacío");
                }
                if (valor.length() > 255) {
                    throw new IllegalArgumentException("El valor de texto excede el máximo de 255 caracteres");
                }
                yield valor;
            }
            case NUMERIC -> {
                try {
                    yield new BigDecimal(valor);
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Valor numérico inválido");
                }
            }
            case BOOLEAN -> {
                if (!"true".equalsIgnoreCase(valor) && !"false".equalsIgnoreCase(valor)) {
                    throw new IllegalArgumentException("Valor booleano inválido");
                }
                yield Boolean.parseBoolean(valor);
            }
            case DATE -> {
                try {
                    yield LocalDate.parse(valor);
                } catch (DateTimeParseException ex) {
                    throw new IllegalArgumentException("Valor de fecha inválido");
                }
            }
        };
    }

    /**
     * Validates and converts the given value to its canonical textual representation
     * according to the specified {@link DataType}.
     *
     * @param valor the raw value as text
     * @param dataType the data type
     * @return canonical string representation of the value
     */
    public static String normalize(String valor, DataType dataType) {
        Object parsed = parse(valor, dataType);
        return parsed.toString();
    }
}

