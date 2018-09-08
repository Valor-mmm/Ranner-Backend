package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotNullArgumentValidatorWithNameTest {

    private final IArgumentValidator NOT_NULL_VALIDATOR = new NotNullArgumentValidator();

    @Test
    void validateExistsTrue() {
        boolean actual = NOT_NULL_VALIDATOR.validateExists(-10.938392, "");
        assertTrue(actual);
    }

    @Test
    void validateExistsNull() {
        boolean actual = NOT_NULL_VALIDATOR.validateExists(null, "thisArgumentWillBeNull");
        assertFalse(actual);
    }

    @Test
    void validateExistsStrictTrue() {
        NOT_NULL_VALIDATOR.validateExistsStrict("string", "StringArg");
    }

    @Test
    void validateExistsStrictNull() {
        String expectedMessage = "The given argument \"\" is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> NOT_NULL_VALIDATOR.validateExistsStrict(null, ""),
                "Exception is not thrown.");
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateTypeTrue() {
        assertTrue(NOT_NULL_VALIDATOR.validateType(new Object(), "object"));
    }

    @Test
    void validateTypeNull() {
        assertTrue(NOT_NULL_VALIDATOR.validateType(null, "funkyTown"));
    }

    @Test
    void validateTypeStrictTrue() {
        NOT_NULL_VALIDATOR.validateTypeStrict("Test", "someParameter");
    }

    @Test
    void validateTypeStrictNull() {
        NOT_NULL_VALIDATOR.validateTypeStrict(null, "");
    }

    @Test
    void checkExistsTrue() {
        boolean actual = NOT_NULL_VALIDATOR.checkExists("Drölf", "bestParamEver");
        assertTrue(actual);
    }

    @Test
    void checkExistsNull() {
        boolean actual = NOT_NULL_VALIDATOR.checkExists(null, "easy");
        assertFalse(actual);
    }

    @Test
    void checkExistsStrictTrue() {
        NOT_NULL_VALIDATOR.checkExistsStrict('s', "charParam");
    }

    @Test
    void checkExistsStrictNull() {
        String expectedMessage = "The given argument \"'baby'@\"unicorn\"\" is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> NOT_NULL_VALIDATOR.checkExistsStrict(null, "'baby'@\"unicorn\""),
                "Exception is not thrown");
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void logValidationResultTrue() {
        NOT_NULL_VALIDATOR.logValidationResult(true, "nice one");
    }

    @Test
    void logValidationResultFalse() {
        NOT_NULL_VALIDATOR.logValidationResult(false, "bad one");
    }
}