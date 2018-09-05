package de.valor.ranner.main.validation.arguments;

/**
 * Class can not use IArgumentValidators due to imminent endless recursions
 */
public class ArgumentLogStringGenerator {

    private static final String typeError = "Given parameter is not of type: ";
    private static final String typeErrorTemplate = "Given parameter \"%s\" is not of type: ";


    private static final String notExistsError = "The given parameter is null or empty.";
    private static final String notExistsErrorTemplate = "The given parameter \"%s\" is null or empty.";

    private static final String nullError = "The given parameter is null.";
    private static final String nullErrorTemplate = "The given parameter \"%s\" is null.";

    private static final String emptyError = "The given parameter is empty.";
    private static final String emptyErrorTemplate = "The given parameter is \"%s\" empty.";

    private static final String existsError = "The given parameter does not exist.";
    private static final String existsErrorTemplate = "The given parameter \"%s\"does not exist.";

    private static final String validateExistResultPositive = "The given parameter does exist and is a valid type.";
    private static final String validateExistResultPositiveTemplate = "The given parameter \"%s\" does exist and is a valid type.";


    private static final String validateExistResultNegative = "The given parameter does not exist or is not a valid type!";
    private static final String validateExistResultNegativeTemplate = "The given parameter \"%s\" does not exist or is not a valid type!";


    public static String getTypeError(String type, String argumentName) {
        return composeValidationResult(typeError, typeErrorTemplate, argumentName) + type;
    }

    public static String getNotExistsError(String argumentName) {
        return composeValidationResult(notExistsError, notExistsErrorTemplate, argumentName);
    }

    public static String getNullError(String argumentName) {
        return composeValidationResult(nullError, nullErrorTemplate, argumentName);
    }

    public static String getEmptyError(String argumentName) {
        return composeValidationResult(emptyError, emptyErrorTemplate, argumentName);
    }

    public static String getExistsError(String argumentName) {
        return composeValidationResult(existsError, notExistsErrorTemplate, argumentName);
    }

    public static String getValidateExistResult(boolean valid, String argumentName) {
        String result;
        if (valid) {
            result = composeValidationResult(validateExistResultPositive, validateExistResultPositiveTemplate, argumentName);
        } else {
            result = composeValidationResult(validateExistResultNegative, validateExistResultNegativeTemplate, argumentName);
        }
        return result;
    }

    private static String composeValidationResult(String defaultValue, String template, String argumentName) {
        String result = defaultValue;
        if (argumentName != null && argumentName.isEmpty()) {
            result = String.format(template, argumentName);
        }
        return result;
    }
}
