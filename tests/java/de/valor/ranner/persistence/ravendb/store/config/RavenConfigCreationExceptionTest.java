package de.valor.ranner.persistence.ravendb.store.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RavenConfigCreationExceptionTest {

    @Test
    void throwRavenConfigCreationException() {
        assertThrows(RavenConfigCreationException.class,
                () -> {
                    throw new RavenConfigCreationException("Some exception", new IllegalArgumentException());
                }
        );
    }

    @Test
    void throwConfigRetrieverExceptionWithNull() {
        assertThrows(RavenConfigCreationException.class,
                () -> {
                    throw new RavenConfigCreationException(null, null);
                }
        );
    }

    @Test
    void getMessage() {
        String expectedMessage = "";
        RavenConfigCreationException actual = assertThrows(RavenConfigCreationException.class,
                () -> {
                    throw new RavenConfigCreationException(expectedMessage, null);
                }
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void getCause() {
        NullPointerException exception = new NullPointerException();
        RavenConfigCreationException actual = assertThrows(RavenConfigCreationException.class,
                () -> {
                    throw new RavenConfigCreationException(null, exception);
                }
        );
        assertEquals(exception, actual.getCause());
    }

}