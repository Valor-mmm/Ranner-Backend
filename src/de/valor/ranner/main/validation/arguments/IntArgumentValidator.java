package de.valor.ranner.main.validation.arguments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArgumentValidator implements IArgumentValidator {

    private static final String type = "Integer";

    private static final Logger logger = LogManager.getLogger(IntArgumentValidator.class);

    @Override
    public boolean validateExists(Object target) {
        boolean correctType = this.validateType(target);
        boolean result = correctType && this.checkExists(target);
        logger.info(ArgumentLogStringGenerator.getValidateExistResult(result));
        return result;
    }

    @Override
    public void validateExistsStrict(Object target) {
        this.validateTypeStrict(target);
        this.checkExistsStrict(target);
    }

    @Override
    public boolean validateType(Object target) {
        return target instanceof Integer;
    }

    @Override
    public void validateTypeStrict(Object target) {
        boolean validType = this.validateType(target);
        this.throwTypeError(!validType);
    }

    @Override
    public boolean checkExists(Object target) {
        return target == null;
    }

    @Override
    public void checkExistsStrict(Object target) {
        boolean doesExist = this.checkExists(target);
        this.throwNotExistsError(!doesExist);
    }

    private void throwTypeError(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getTypeError(type));
        }
    }

    private void throwNotExistsError(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getNotExistsError());
        }
    }

}
