package de.valor.ranner.main.validation.arguments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArgumentValidator implements IArgumentValidator {

    private static final String type = "Integer";

    private static final Logger logger = LogManager.getLogger(IntArgumentValidator.class);

    @Override
    public boolean validateType(Object target, String argumentName) {
        boolean result = target instanceof Integer;
        if (!result) {
            String logMsg = ArgumentLogStringGenerator.getTypeError(type, argumentName);
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
        boolean result = !(target == null);
        if (!result) {
            String msg = ArgumentLogStringGenerator.getNotExistsError(argumentName);
            logger.info(msg);
        }
        return result;
    }

    @Override
    public void checkExistsStrict(Object target, String argumentName) {
        boolean doesExist = this.checkExists(target, argumentName);
        this.throwNotExistsError(!doesExist, argumentName);
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
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getTypeError(type, argumentName));
        }
    }

    private void throwNotExistsError(boolean shouldThrow, String argumentName) {
        if (shouldThrow) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getNotExistsError(argumentName));
        }
    }

}
