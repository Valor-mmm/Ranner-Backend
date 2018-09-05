package de.valor.ranner.main.validation.arguments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotNullArgumentValidator implements IArgumentValidator {

    private static final Logger logger = LogManager.getLogger(NotNullArgumentValidator.class);

    @Override
    public boolean validateType(Object target) {
        return true; // no type to validate
    }

    @Override
    public void validateTypeStrict(Object target) {
        // no type to validate
    }

    @Override
    public boolean checkExists(Object target) {
        return target == null;
    }

    @Override
    public void checkExistsStrict(Object target) {
        boolean doesExist = this.checkExists(target);
        this.throwNullError(!doesExist);
    }

    @Override
    public void logValidationResult(boolean result) {
        logger.info(ArgumentLogStringGenerator.getValidateExistResult(result));
    }

    private void throwNullError(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getNullError());
        }
    }
}
