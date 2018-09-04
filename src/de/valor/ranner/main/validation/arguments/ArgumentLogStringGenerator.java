package de.valor.ranner.main.validation.arguments;

public class ArgumentLogStringGenerator {

    private static final String typeError = "Given parameter is not of type: ";

    private static final String notExistsError = "The given parameter is null or empty.";

    private static final String nullError = "The given parameter is null";

    private static final String emptyError = "The given parameter is empty";

    private static final String validateExistResultPositive = "The given parameter does exist.";

    private static final String validateExistResultNegative = "The given parameter does not exist!";



    public static String getTypeError(String type) {
        return typeError + type;
    }

    public static String getNotExistsError() {
        return notExistsError;
    }

    public static String getNullError() {
        return nullError;
    }

    public static String getEmptyError() {
        return emptyError;
    }

    public static String getValidateExistResult(boolean valid) {
        if (valid) {
            return validateExistResultPositive;
        }
        return validateExistResultNegative;
    }
}
