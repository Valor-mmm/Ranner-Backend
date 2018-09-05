package de.valor.ranner.main.validation.arguments;

public interface IArgumentValidator {

    default boolean validateExists(Object target) {
        boolean correctType = this.validateType(target);
        boolean result = correctType && this.checkExists(target);
        logValidationResult(result);
        return result;
    }

    default void validateExistsStrict(Object target) {
        validateTypeStrict(target);
        checkExistsStrict(target);
    }

    boolean validateType(Object target);

    void validateTypeStrict(Object target);

    boolean checkExists(Object target);

    void checkExistsStrict(Object target);

    void logValidationResult(boolean result);

}
