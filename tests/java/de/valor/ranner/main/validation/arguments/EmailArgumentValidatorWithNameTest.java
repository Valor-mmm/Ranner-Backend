package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmailArgumentValidatorWithNameTest {

    private IArgumentValidator emailArgValidator = new EmailArgumentValidator();

    @Test
    void validateTypeValid() {
        assertTrue(emailArgValidator.validateType("", ""));
    }

    @Test
    void validateTypeInvalid() {
        assertFalse(emailArgValidator.validateType(new Object(), "email arg"));
    }

    @Test
    void validateTypeNull() {
        assertFalse(emailArgValidator.validateType(null, "nullArg"));
    }

    @Test
    void validateTypeStrictValid() {
        emailArgValidator.validateTypeStrict("", "a very valid arg");
    }

    @Test
    void validateTypeStrictInvalid() {
        String argName = "the argument invalid";
        String cause = "Given argument \"" + argName + "\" is not of type: String";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> emailArgValidator.validateTypeStrict(new BigDecimal(10), argName)
        );
        assertEquals(cause, actual.getMessage());
    }

    @Test
    void validateTypeStrictNull() {
        String argName = "";
        String cause = "The given argument \"" + argName + "\" is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> emailArgValidator.validateTypeStrict(null, argName)
        );
        assertEquals(cause, actual.getMessage());
    }

    @Test
    void checkExistsValid() {
        assertTrue(emailArgValidator.checkExists("test@validMail.com", ""));
    }

    @Test
    void checkExistsInvalid() {
        assertFalse(emailArgValidator.validateExists("noEmail.it", "yaa"));
    }

    @Test
    void checkExistsNull() {
        assertFalse(emailArgValidator.validateExists(null, "another argument"));
    }

    @Test
    void checkExistsStrictValid() {
        emailArgValidator.validateExistsStrict("test@i-will-net.tk", "anotherOneArg");
    }

    @Test
    void checkExistsStrictInvalid() {
        String argName = "a%&$?+~test";
        String cause = "The given argument \"" + argName + "\" is null or empty.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> emailArgValidator.checkExistsStrict("invalid@email", argName)
        );
        assertEquals(cause, actual.getMessage());
    }

    @Test
    void checkExistsStrictNull() {
        String argName = "€@taerskjn";
        String cause = "The given argument \"" + argName + "\" is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> emailArgValidator.checkExistsStrict(null, argName)
        );
        assertEquals(cause, actual.getMessage());
    }

    @Test
    void logValidationResultTrue() {
        emailArgValidator.logValidationResult(true, "testArg");
    }

    @Test
    void logValidationResultFalse() {
        emailArgValidator.logValidationResult(false, "anotherArg");
    }
}