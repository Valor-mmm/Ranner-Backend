package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class StringArgumentValidatorWithNameTest {

    private final IArgumentValidator STRING_VALIDATOR = new StringArgumentValidator();

    @Test
    void validateExistsString() {
        boolean actual = STRING_VALIDATOR.validateExists("Some @ Test", "");
        assertTrue(actual);
    }

    @Test
    void validateExistsEmpty() {
        boolean actual = STRING_VALIDATOR.validateExists("", "unicornmaster");
        assertFalse(actual);
    }

    @Test
    void validateExistsWrongType() {
        boolean actual = STRING_VALIDATOR.validateExists(false, "notOfTypeString");
        assertFalse(actual);
    }

    @Test
    void validateExistsNull() {
        boolean actual = STRING_VALIDATOR.validateExists(null, "nullParam");
        assertFalse(actual);
    }

    @Test
    void validateExistsStrictString() {
        STRING_VALIDATOR.validateExistsStrict("@", "this is Argument");
    }

    @Test
    void validateExistsStrictEmpty() {
        String expectedMessage = "The given argument \"arg\" is empty.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateExistsStrict("", "arg")
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateExistsStrictWrongType() {
        String expectedMessage = "Given argument \"so objective\" is not of type: String";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateExistsStrict(new TreeMap<String, Object>(), "so objective")
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateExistsStrictNull() {
        String expectedMessage = "The given argument \"\" is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateExistsStrict(null, "")
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateTypeString() {
        boolean actual = STRING_VALIDATOR.validateType("valid \"\" String \"", "\t");
        assertTrue(actual);
    }

    @Test
    void validateTypeEmpty() {
        boolean actual = STRING_VALIDATOR.validateType("\t", "tabString");
        assertTrue(actual);
    }

    @Test
    void validateTypeWrongType() {
        boolean actual = STRING_VALIDATOR.validateType(true, "booleanParam");
        assertFalse(actual);
    }

    @Test
    void validateTypeNull() {
        boolean actual = STRING_VALIDATOR.validateType(null , "not valid at all");
        assertFalse(actual);
    }

    @Test
    void validateTypeStrictString() {
        STRING_VALIDATOR.validateTypeStrict(";", "\\a");
    }

    @Test
    void validateTypeStrictEmpty() {
        STRING_VALIDATOR.validateTypeStrict(" ", "a\\a\\a");
    }

    @Test
    void validateTypeStrictWrongType() {
        String expectedMessage = "Given argument \"@µ²³¼\" is not of type: String";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateTypeStrict(new Object(), "@µ²³¼")
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void validateTypeStrictNull() {
        String expectedMessage = "The given argument \"nullObjectFound\" is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.validateTypeStrict(null, "nullObjectFound")
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void checkExistsString() {
        boolean actual = STRING_VALIDATOR.checkExists("some valid String ¼½¬{[{¬½{{¼²³¼½½", "³¼½");
        assertTrue(actual);
    }

    @Test
    void checkExistsEmpty() {
        boolean actual = STRING_VALIDATOR.checkExists("", "");
        assertFalse(actual);
    }

    @Test
    void checkExistsWrongType() {
        boolean actual = STRING_VALIDATOR.checkExists(true, "asdf");
        assertFalse(actual);
    }

    @Test
    void checkExistsNull() {
        boolean actual = STRING_VALIDATOR.checkExists(null, "damn");
        assertFalse(actual);
    }

    @Test
    void checkExistsStrictString() {
        STRING_VALIDATOR.checkExistsStrict("drölf", "drölf");
    }

    @Test
    void checkExistsStrictEmpty() {
        String expectedMessage = "The given argument \"drölf\" is empty.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.checkExistsStrict("", "drölf")
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void checkExistsStrictWrongType() {
        String expectedMessage = "Given argument is not of type: String";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.checkExistsStrict(49.0, null)
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void checkExistsStrictNull() {
        String expectedMessage = "The given argument \"\t\" is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> STRING_VALIDATOR.checkExistsStrict(null, "\t")
        );
        assertEquals(expectedMessage, actual.getMessage());
    }

    @Test
    void logValidationResultTrue() {
        STRING_VALIDATOR.logValidationResult(true, "argTrue");
    }

    @Test
    void logValidationResultFalse() {
        STRING_VALIDATOR.logValidationResult(false, "argFalse");
    }
}