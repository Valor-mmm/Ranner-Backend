package de.valor.ranner.main.validation.arguments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArgumentLogStringGeneratorWithNameTest {

    @Test
    void getTypeError() {
        String expected = "Given argument \"someParameter\" is not of type: String";
        String actual = ArgumentLogStringGenerator.getTypeError("String", "someParameter");
        assertEquals(expected, actual);
    }

    @Test
    void getNotExistsError() {
        String expected = "The given argument \"test\" is null or empty.";
        String actual = ArgumentLogStringGenerator.getNotExistsError("test");
        assertEquals(expected, actual);
    }

    @Test
    void getNullError() {
        String expected = "The given argument \"unicorn\" is null.";
        String actual = ArgumentLogStringGenerator.getNullError("unicorn");
        assertEquals(expected, actual);
    }

    @Test
    void getEmptyError() {
        String expected = "The given argument \"bunny\" is empty.";
        String actual = ArgumentLogStringGenerator.getEmptyError("bunny");
        assertEquals(expected, actual);
    }

    @Test
    void getValidateExistResultTrue() {
        String expected = "The given argument \"mouse\" does exist and is a valid type.";
        String actual = ArgumentLogStringGenerator.getValidateExistResult(true, "mouse");
        assertEquals(expected, actual);
    }

    @Test
    void getValidateExistResultFalse() {
        String expected = "The given argument \"\" does not exist or is not a valid type!";
        String actual = ArgumentLogStringGenerator.getValidateExistResult(false, "");
        assertEquals(expected, actual);
    }
}
