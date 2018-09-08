package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class StringArgumentValidatorTest {

    private final IArgumentValidator STRING_VALIDATOR = new StringArgumentValidator();

    @Test
    void validateExistsString() {
        boolean actual = STRING_VALIDATOR.validateExists("Some string", null);
        assertTrue(actual);
    }

    @Test
    void validateExistsEmpty() {
        boolean actual = STRING_VALIDATOR.validateExists("", null);
        assertFalse(actual);
    }

    @Test
    void validateExistsWrongType() {
        boolean actual = STRING_VALIDATOR.validateExists(49, null);
        assertFalse(actual);
    }

    @Test
    void validateExistsNull() {
        boolean actual = STRING_VALIDATOR.validateExists(null, null);
        assertFalse(actual);
    }

    @Test
    void validateExistsStrictString() {
        STRING_VALIDATOR.validateExistsStrict("valid String", null);
    }

    @Test
    void validateExistsStrictEmpty() {
        String expectedMessage = "The given argument is empty.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateExistsStrict("", null)
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateExistsStrictWrongType() {
        String expectedMessage = "Given argument is not of type: String";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateExistsStrict(new Object(), null)
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateExistsStrictNull() {
        String expectedMessage = "The given argument is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateExistsStrict(null, null)
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateTypeString() {
        boolean actual = STRING_VALIDATOR.validateType("valid \"\" String \"", null);
        assertTrue(actual);
    }

    @Test
    void validateTypeEmpty() {
        boolean actual = STRING_VALIDATOR.validateType("", null);
        assertTrue(actual);
    }

    @Test
    void validateTypeWrongType() {
        boolean actual = STRING_VALIDATOR.validateType('c', null);
        assertFalse(actual);
    }

    @Test
    void validateTypeNull() {
        boolean actual = STRING_VALIDATOR.validateType(null , null);
        assertFalse(actual);
    }

    @Test
    void validateTypeStrictString() {
        STRING_VALIDATOR.validateTypeStrict("some ''''' String \"@ with endoding stuff €€€µ;", null);
    }

    @Test
    void validateTypeStrictEmpty() {
        STRING_VALIDATOR.validateTypeStrict("", null);
    }

    @Test
    void validateTypeStrictWrongType() {
        String expectedMessage = "Given argument is not of type: String";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateTypeStrict(-10.0000000000245876, null)
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateTypeStrictNull() {
        String expectedMessage = "The given argument is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateTypeStrict(null, null)
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void checkExistsString() {
        boolean actual = STRING_VALIDATOR.checkExists("this is a String @€µ~³²Chars", null);
        assertTrue(actual);
    }

    @Test
    void checkExistsEmpty() {
        boolean actual = STRING_VALIDATOR.checkExists("", null);
        assertFalse(actual);
    }

    @Test
    void checkExistsWrongType() {
        boolean actual = STRING_VALIDATOR.checkExists(new HashSet<String>(), null);
        assertFalse(actual);
    }

    @Test
    void checkExistsNull() {
        boolean actual = STRING_VALIDATOR.checkExists(null, null);
        assertFalse(actual);
    }

    @Test
    void checkExistsStrictString() {
        STRING_VALIDATOR.checkExistsStrict("this is a mighty string: FUS ROH DAH. Or something like that", null);
    }

    @Test
    void checkExistsStrictEmpty() {
        String expectedMessage = "The given argument is empty.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.checkExistsStrict("", null)
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void checkExistsStrictWrongType() {
        String expectedMessage = "Given argument is not of type: String";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.checkExistsStrict(true, null)
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void checkExistsStrictNull() {
        String expectedMessage = "The given argument is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.checkExistsStrict(null, null)
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void logValidationResultTrue() {
        STRING_VALIDATOR.logValidationResult(true, null);
    }

    @Test
    void logValidationResultFalse() {
        STRING_VALIDATOR.logValidationResult(false, null);
    }
}