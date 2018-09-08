package de.valor.ranner.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigRetrieverExceptionTest {

    @Test
    void throwConfigRetrieverException() {
        assertThrows(ConfigRetrieverException.class, () -> {
            throw new ConfigRetrieverException("Message", new NullPointerException());
        });
    }

    @Test
    void throwConfigRetrieverExceptionWithNull() {
        assertThrows(ConfigRetrieverException.class, () -> {
            throw new ConfigRetrieverException(null, null);
        });
    }

    @Test
    void getMessage() {
        String message = "Message@€~³¼½{¬{";
        ConfigRetrieverException actual = assertThrows(ConfigRetrieverException.class, () -> {
            throw new ConfigRetrieverException(message, null);
        });
        assertEquals(message, actual.getMessage());
    }

    @Test
    void getThrowable() {
        Throwable exception = new NullPointerException();
        ConfigRetrieverException actual = assertThrows(ConfigRetrieverException.class, () -> {
            throw new ConfigRetrieverException(null, exception);
        });
        assertEquals(exception, actual.getCause());
    }

}