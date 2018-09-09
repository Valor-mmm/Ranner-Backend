package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NotNullArgumentValidatorTest {

    private final IArgumentValidator NOT_NULL_VALIDATOR = new NotNullArgumentValidator();

    @Test
    void createNotNullValidator() {
        new NotNullArgumentValidator();
    }

    @Test
    void validateExistsTrue() {
        boolean actual = NOT_NULL_VALIDATOR.validateExists(new Object(), null);
        assertTrue(actual);
    }

    @Test
    void validateExistsNull() {
        boolean actual = NOT_NULL_VALIDATOR.validateExists(null, null);
        assertFalse(actual);
    }

    @Test
    void validateExistsStrictTrue() {
        NOT_NULL_VALIDATOR.validateExistsStrict(40.8, null);
    }

    @Test
    void validateExistsStrictNull() {
        String expectedMessage = "The given argument is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> NOT_NULL_VALIDATOR.validateExistsStrict(null, null),
                "Exception is not thrown.");
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateTypeTrue() {
        assertTrue(NOT_NULL_VALIDATOR.validateType("stringType", null));
    }

    @Test
    void validateTypeNull() {
        assertTrue(NOT_NULL_VALIDATOR.validateType(null, null));
    }

    @Test
    void validateTypeStrictTrue() {
        NOT_NULL_VALIDATOR.validateTypeStrict(new ArrayList<Double>(), null);
    }

    @Test
    void validateTypeStrictNull() {
        NOT_NULL_VALIDATOR.validateTypeStrict(null, null);
    }

    @Test
    void checkExistsTrue() {
        boolean actual = NOT_NULL_VALIDATOR.checkExists('c', null);
        assertTrue(actual);
    }

    @Test
    void checkExistsNull() {
        boolean actual = NOT_NULL_VALIDATOR.checkExists(null, null);
        assertFalse(actual);
    }

    @Test
    void checkExistsStrictTrue() {
        NOT_NULL_VALIDATOR.checkExistsStrict(-100000, null);
    }

    @Test
    void checkExistsStrictNull() {
        String expectedMessage = "The given argument is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> NOT_NULL_VALIDATOR.checkExistsStrict(null, null),
                "Exception is not thrown");
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void logValidationResultTrue() {
        NOT_NULL_VALIDATOR.logValidationResult(true, null);
    }

    @Test
    void logValidationResultFalse() {
        NOT_NULL_VALIDATOR.logValidationResult(false, null);
    }
}