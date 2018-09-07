package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IntArgumentValidatorWithNameTest {

    private IArgumentValidator intArgumentValidator = new IntArgumentValidator();

    @Test
    void validateExistsInt() {
        boolean actual = intArgumentValidator.validateExists(-66, "someArgument");
        assertTrue(actual);
    }

    @Test
    void validateExistsNull() {
        boolean actual = intArgumentValidator.validateExists(null, "");
        assertFalse(actual);
    }

    @Test
    void validateExistsWrongType() {
        boolean actual = intArgumentValidator.validateExists(20.8, "prram€");
        assertFalse(actual);
    }

    @Test
    void validateExistsStrictInt() {
        intArgumentValidator.validateExistsStrict(90, "Test");
    }

    @Test
    void validateExistsStrictNull() {
        String expectedMessage = "The given argument \"\" is null.";
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.validateExistsStrict(null, "")
        );
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    void validateExistsStrictWrongType() {
        String expectedMessage = "Given argument \"arg\" is not of type: Integer";
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.validateExistsStrict("", "arg")
        );
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    void validateTypeInt() {
        boolean actual = intArgumentValidator.validateType(80, "");
        assertTrue(actual);
    }

    @Test
    void validateTypeNull() {
        boolean actual = intArgumentValidator.validateType(null, "nullArgument");
        assertFalse(actual);
    }

    @Test
    void validateTypeWrongType() {
        boolean actual = intArgumentValidator.validateType(new BigDecimal(90), "bigDecimalParameter");
        assertFalse(actual);
    }

    @Test
    void validateTypeStrictInt() {
        intArgumentValidator.validateTypeStrict(0, "");
    }

    @Test
    void validateTypeStrictNull() {
        String expectedMessage = "The given argument \"Tricky\"test\" is null.";
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.validateTypeStrict(null, "Tricky\"test")
        );
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    void validateTypeStrictWrongType() {
        String expectedMessage = "Given argument \".0 Parameter\" is not of type: Integer";
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.validateTypeStrict(60.0, ".0 Parameter")
        );
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    void checkExistsInt() {
        boolean actual = intArgumentValidator.checkExists(0, "zero");
        assertTrue(actual);
    }

    @Test
    void checkExistsNull() {
        boolean actual = intArgumentValidator.checkExists(null, "@ParameterZero");
        assertFalse(actual);
    }


    @Test
    void checkExistsWrongType() {
        boolean actual = intArgumentValidator.checkExists(true, "RandomInputString: '\"\''");
        assertTrue(actual);
    }

    @Test
    void checkExistsStrictInt() {
        intArgumentValidator.checkExistsStrict(10000, "Long number");
    }

    @Test
    void checkExistsStrictNull() {
        String expectedMessage = "The given argument \"NullParam\" is null or empty.";
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class,
                () -> intArgumentValidator.checkExistsStrict(null, "NullParam")
        );
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    void checkExistsStrictWrongType() {
        intArgumentValidator.checkExistsStrict(true,
                "Exists but is wrong type");
    }

    @Test
    void logValidationResultTrue() {
        intArgumentValidator.logValidationResult(true, "This name will be logged");
    }

    @Test
    void logValidationResultFalse() {
        intArgumentValidator.logValidationResult(false, "This name will also be logged");
    }
}