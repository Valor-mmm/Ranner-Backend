package de.valor.ranner.main.validation.arguments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotNullArgumentValidator implements IArgumentValidator {

    private static final Logger logger = LogManager.getLogger(NotNullArgumentValidator.class);

    @Override
    public boolean validateType(Object target, String argumentName) {
        return true; // no type to validate
    }

    @Override
    public void validateTypeStrict(Object target, String argumentName) {
        // no type to validate
    }

    @Override
    public boolean checkExists(Object target, String argumentName) {
        boolean result = !(target == null);
        if (!result) {
            String logMsg = ArgumentLogStringGenerator.getNotExistsError(argumentName);
            logger.info(logMsg);
        }
        return result;
    }

    @Override
    public void checkExistsStrict(Object target, String argumentName) {
        boolean doesExist = this.checkExists(target, argumentName);
        this.throwNullError(!doesExist, argumentName);
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
}
