package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IntArgumentValidatorTest {

    private IArgumentValidator intArgumentValidator = new IntArgumentValidator();

    private static final String nullMessage = "The given argument is null.";
    private static final String wrongTypeMessage = "Given argument is not of type: Integer";
    private static final String notExistsMessage = "The given argument is null or empty.";

    @Test
    void createIntArgumentValidator() {
        new IntArgumentValidator();
    }

    @Test
    void validateExistsInt() {
        boolean actual = intArgumentValidator.validateExists(4, null);
        assertTrue(actual);
    }

    @Test
    void validateExistsNull() {
        boolean actual = intArgumentValidator.validateExists(null, null);
        assertFalse(actual);
    }

    @Test
    void validateExistsWrongType() {
        boolean actual = intArgumentValidator.validateExists("WrongType", null);
        assertFalse(actual);
    }

    @Test
    void validateExistsStrictInt() {
        intArgumentValidator.validateExistsStrict(90, null);
    }

    @Test
    void validateExistsStrictNull() {
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.validateExistsStrict(null, null)
        );
        assertEquals(nullMessage, actualException.getMessage());
    }

    @Test
    void validateExistsStrictWrongType() {
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.validateExistsStrict(7.8, null)
        );
        assertEquals(wrongTypeMessage, actualException.getMessage());
    }

    @Test
    void validateTypeInt() {
        boolean actual = intArgumentValidator.validateType(1000, null);
        assertTrue(actual);
    }

    @Test
    void validateTypeNull() {
        boolean actual = intArgumentValidator.validateType(null, null);
        assertFalse(actual);
    }

    @Test
    void validateTypeWrongType() {
        boolean actual = intArgumentValidator.validateType(new ArrayList<Integer>(), null);
        assertFalse(actual);
    }

    @Test
    void validateTypeStrictInt() {
        intArgumentValidator.validateTypeStrict(0, null);
    }

    @Test
    void validateTypeStrictNull() {
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.validateTypeStrict(null, null)
        );
        assertEquals(nullMessage, actualException.getMessage());
    }

    @Test
    void validateTypeStrictWrongType() {
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.validateTypeStrict("Wrong", null)
        );
        assertEquals(wrongTypeMessage, actualException.getMessage());
    }

    @Test
    void checkExistsInt() {
        boolean actual = intArgumentValidator.checkExists(2, null);
        assertTrue(actual);
    }

    @Test
    void checkExistsNull() {
        boolean actual = intArgumentValidator.checkExists(null, null);
        assertFalse(actual);
    }


    @Test
    void checkExistsWrongType() {
        boolean actual = intArgumentValidator.checkExists("", null);
        assertTrue(actual);
    }

    @Test
    void checkExistsStrictInt() {
        intArgumentValidator.checkExistsStrict(-100, null);
    }

    @Test
    void checkExistsStrictNull() {
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.checkExistsStrict(null, null)
        );
        assertEquals(notExistsMessage, actualException.getMessage());
    }

    @Test
    void checkExistsStrictWrongType() {
        intArgumentValidator.checkExistsStrict(false, null);
    }

    @Test
    void logValidationResultTrue() {
        intArgumentValidator.logValidationResult(true, null);
    }

    @Test
    void logValidationResultFalse() {
        intArgumentValidator.logValidationResult(false, null);
    }
}