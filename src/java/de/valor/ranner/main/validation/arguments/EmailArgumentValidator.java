package de.valor.ranner.main.validation.arguments;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailArgumentValidator implements IArgumentValidator {

    public static final Logger logger = LogManager.getLogger(EmailArgumentValidator.class);

    private static final String TYPE = "String";

    private static final EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean validateType(Object target, String argumentName) {
        boolean result = target instanceof String;
        if (!result) {
            String logMsg = ArgumentLogStringGenerator.getTypeError(TYPE, argumentName);
            logger.info(logMsg);
        }
        return result;
    }

    @Override
    public void validateTypeStrict(Object target, String argumentName) {
        throwNullError(target == null, argumentName);
        boolean validType = this.validateType(target, argumentName);
        this.throwTypeError(!validType, argumentName);
    }

    @Override
    public boolean checkExists(Object target, String argumentName) {
        boolean result = target != null;
        if (!result) {
            String msg = ArgumentLogStringGenerator.getNullError(argumentName);
            logger.info(msg);
            return false;
        }

        if (!validateType(target, argumentName)) {
            return false;
        }

        String emailString = (String) target;
        result = emailValidator.isValid(emailString);
        return result;
    }

    @Override
    public void checkExistsStrict(Object target, String argumentName) {
        throwNullError(target == null, argumentName);
        validateTypeStrict(target, argumentName);
        String emailString = (String) target;
        throwNotExistsError(!emailValidator.isValid(emailString), argumentName);
    }

    @Override
    public void logValidationResult(boolean result, String argumentName) {
        logger.info(ArgumentLogStringGenerator.getValidateExistResult(result, argumentName));
    }

    private void throwNullError(boolean shouldThrow, String argumentName) {
        if (shouldThrow) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getNullError(argumentName));
        }
    }

    private void throwTypeError(boolean shouldThrow, String argumentName) {
        if (shouldThrow) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getTypeError(TYPE, argumentName));
        }
    }

    private void throwNotExistsError(boolean shouldThrow, String argumentName) {
        if (shouldThrow) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getNotExistsError(argumentName));
        }
    }
}
