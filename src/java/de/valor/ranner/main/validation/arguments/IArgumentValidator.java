package de.valor.ranner.main.validation.arguments;

public interface IArgumentValidator {

    default boolean validateExists(Object target, String argumentName) {
        boolean correctType = this.validateType(target, argumentName);
        boolean result = correctType && this.checkExists(target, argumentName);
        logValidationResult(result, argumentName);
        return result;
    }

    default void validateExistsStrict(Object target, String argumentName) {
        validateTypeStrict(target, argumentName);
        checkExistsStrict(target, argumentName);
    }

    boolean validateType(Object target, String argumentName);

    void validateTypeStrict(Object target, String argumentName);

    boolean checkExists(Object target, String argumentName);

    void checkExistsStrict(Object target, String argumentName);

    void logValidationResult(boolean result, String argumentName);

}
