package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailArgumentValidatorTest {

    private IArgumentValidator emailArgValidator = new EmailArgumentValidator();

    @Test
    void validateTypeValid() {
        assertTrue(emailArgValidator.validateType("some email string", null));
    }

    @Test
    void validateTypeInvalid() {
        assertFalse(emailArgValidator.validateType(0, null));
    }

    @Test
    void validateTypeNull() {
        assertFalse(emailArgValidator.validateType(null, null));
    }

    @Test
    void validateTypeStrictValid() {
        emailArgValidator.validateTypeStrict("someString", null);
    }

    @Test
    void validateTypeStrictInvalid() {
        String cause = "Given argument is not of type: String";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> emailArgValidator.validateTypeStrict(10.9, null)
        );
        assertEquals(cause, actual.getMessage());
    }

    @Test
    void validateTypeStrictNull() {
        String cause = "The given argument is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> emailArgValidator.validateTypeStrict(null, null)
        );
        assertEquals(cause, actual.getMessage());
    }

    @Test
    void checkExistsValid() {
        assertTrue(emailArgValidator.checkExists("test@test.com", null));
    }

    @Test
    void checkExistsInvalid() {
        assertFalse(emailArgValidator.validateExists("noEmailAddress.com", null));
    }

    @Test
    void checkExistsNull() {
        assertFalse(emailArgValidator.validateExists(null, null));
    }

    @Test
    void checkExistsStrictValid() {
        emailArgValidator.validateExistsStrict("valid@i-will-net.de", null);
    }

    @Test
    void checkExistsStrictInvalid() {
        String cause = "The given argument is null or empty.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> emailArgValidator.checkExistsStrict("invalid@email", null)
        );
        assertEquals(cause, actual.getMessage());
    }

    @Test
    void checkExistsStrictNull() {
        String cause = "The given argument is null.";
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                () -> emailArgValidator.checkExistsStrict(null, null)
        );
        assertEquals(cause, actual.getMessage());
    }

    @Test
    void logValidationResultTrue() {
        emailArgValidator.logValidationResult(true, null);
    }

    @Test
    void logValidationResultFalse() {
        emailArgValidator.logValidationResult(false, null);
    }
}