package de.valor.ranner.main.validation.arguments;

/**
 * Class can not use IArgumentValidators due to imminent endless recursions
 */
class ArgumentLogStringGenerator {

    private static final String TYPE_ERROR = "Given argument is not of type: ";
    private static final String TYPE_ERROR_TEMPLATE = "Given argument \"%s\" is not of type: ";

    private static final String NOT_EXISTS_ERROR = "The given argument is null or empty.";
    private static final String NOT_EXISTS_ERROR_TEMPLATE = "The given argument \"%s\" is null or empty.";

    private static final String NULL_ERROR = "The given argument is null.";
    private static final String NULL_ERROR_TEMPLATE = "The given argument \"%s\" is null.";

    private static final String EMPTY_ERROR = "The given argument is empty.";
    private static final String EMPTY_ERROR_TEMPLATE = "The given argument \"%s\" is empty.";

    private static final String VALIDATE_EXIST_RESULT_POSITIVE = "The given argument does exist and is a valid type.";
    private static final String VALIDATE_EXIST_RESULT_POSITIVE_TEMPLATE = "The given argument \"%s\" does exist and is a valid type.";

    private static final String VALIDATE_EXIST_RESULT_NEGATIVE = "The given argument does not exist or is not a valid type!";
    private static final String VALIDATE_EXIST_RESULT_NEGATIVE_TEMPLATE = "The given argument \"%s\" does not exist or is not a valid type!";


    static String getTypeError(String type, String argumentName) {
        return composeValidationResult(TYPE_ERROR, TYPE_ERROR_TEMPLATE, argumentName) + type;
    }

    static String getNotExistsError(String argumentName) {
        return composeValidationResult(NOT_EXISTS_ERROR, NOT_EXISTS_ERROR_TEMPLATE, argumentName);
    }

    static String getNullError(String argumentName) {
        return composeValidationResult(NULL_ERROR, NULL_ERROR_TEMPLATE, argumentName);
    }

    static String getEmptyError(String argumentName) {
        return composeValidationResult(EMPTY_ERROR, EMPTY_ERROR_TEMPLATE, argumentName);
    }

    static String getValidateExistResult(boolean valid, String argumentName) {
        String result;
        if (valid) {
            result = composeValidationResult(VALIDATE_EXIST_RESULT_POSITIVE, VALIDATE_EXIST_RESULT_POSITIVE_TEMPLATE, argumentName);
        } else {
            result = composeValidationResult(VALIDATE_EXIST_RESULT_NEGATIVE, VALIDATE_EXIST_RESULT_NEGATIVE_TEMPLATE, argumentName);
        }
        return result;
    }

    private static String composeValidationResult(String defaultValue, String template, String argumentName) {
        String result = defaultValue;
        if (argumentName != null) {
            result = String.format(template, argumentName);
        }
        return result;
    }
}
