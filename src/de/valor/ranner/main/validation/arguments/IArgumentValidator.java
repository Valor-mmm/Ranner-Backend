package de.valor.ranner.main.validation.arguments;

public interface IArgumentValidator {

    boolean validateExists(Object target);

    boolean validateExistsStrict(Object target);

    boolean validateType(Object target);

    boolean validateTypeStrict(Object target);

    boolean checkExists(Object target);

    boolean checkExistsStrict(Object target);

}
