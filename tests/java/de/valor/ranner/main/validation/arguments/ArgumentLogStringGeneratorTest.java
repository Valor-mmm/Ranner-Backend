package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentLogStringGeneratorTest {

    @Test
    void createArgumentLogStringGenerator() {
        new ArgumentLogStringGenerator();
    }

    @Test
    void getTypeError() {
        String expected = "Given argument is not of type: String";
        String actual = ArgumentLogStringGenerator.getTypeError("String", null);
        assertEquals(expected, actual);
    }

    @Test
    void getNotExistsError() {
        String expected = "The given argument is null or empty.";
        String actual = ArgumentLogStringGenerator.getNotExistsError(null);
        assertEquals(expected, actual);
    }

    @Test
    void getNullError() {
        String expected = "The given argument is null.";
        String actual = ArgumentLogStringGenerator.getNullError(null);
        assertEquals(expected, actual);
    }

    @Test
    void getEmptyError() {
        String expected = "The given argument is empty.";
        String actual = ArgumentLogStringGenerator.getEmptyError(null);
        assertEquals(expected, actual);
    }

    @Test
    void getValidateExistResultTrue() {
        String expected = "The given argument does exist and is a valid type.";
        String actual = ArgumentLogStringGenerator.getValidateExistResult(true, null);
        assertEquals(expected, actual);
    }

    @Test
    void getValidateExistResultFalse() {
        String expected = "The given argument does not exist or is not a valid type!";
        String actual = ArgumentLogStringGenerator.getValidateExistResult(false, null);
        assertEquals(expected, actual);
    }
}