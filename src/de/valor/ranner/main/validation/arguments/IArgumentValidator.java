package de.valor.ranner.main.validation.arguments;

public interface IArgumentValidator {

    boolean validateExists(Object target);

    void validateExistsStrict(Object target);

    boolean validateType(Object target);

    void validateTypeStrict(Object target);

    boolean checkExists(Object target);

    void checkExistsStrict(Object target);

}
