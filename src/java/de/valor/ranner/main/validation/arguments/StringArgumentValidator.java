package de.valor.ranner.main.validation.arguments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringArgumentValidator implements IArgumentValidator {

    private static final String type = "String";

    private static final Logger logger = LogManager.getLogger(StringArgumentValidator.class);

    @Override
    public boolean validateType(Object target, String argumentName) {
        boolean result =  target instanceof String;
        if (!result) {
            String logMsg = ArgumentLogStringGenerator.getTypeError(type, argumentName);
            logger.info(logMsg);
        }
        return result;
    }

    @Override
    public void validateTypeStrict(Object target, String argumentName) {
        isNullStrict(target, argumentName);
        if (!(target instanceof String)) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getTypeError(type, argumentName));
        }
    }

    @Override
    public boolean checkExists(Object target, String argumentName) {
        boolean result = !this.isNull(target, argumentName);
        result = result && this.validateType(target, argumentName);
        return result && !this.isEmpty((String) target, argumentName);
    }

    @Override
    public void checkExistsStrict(Object target, String argumentName) {
        this.isNullStrict(target, argumentName);
        this.validateTypeStrict(target, argumentName);
        this.isEmptyStrict(target, argumentName);
    }

    @Override
    public void logValidationResult(boolean result, String argumentName) {
        logger.info(ArgumentLogStringGenerator.getValidateExistResult(result, argumentName));
    }

    private void isNullStrict(Object target, String argumentName) {
        if (target == null) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getNullError(argumentName));
        }
    }

    private void isEmptyStrict(Object target, String argumentName) {
        this.isNullStrict(target, argumentName);
        boolean isEmpty = isEmpty((String) target, argumentName);
        this.throwEmptyError(isEmpty, argumentName);
    }

    private boolean isEmpty (String target, String argumentName) {
        boolean isNull = this.isNull(target, argumentName);
        return !isNull && target.isEmpty();
    }

    private boolean isNull (Object target, String argumentName) {
        boolean result = target == null;
        if (!result) {
            String logMsg = ArgumentLogStringGenerator.getNullError(argumentName);
            logger.info(logMsg);
        }
        return result;
    }

    private void throwEmptyError(boolean shouldThrow, String argumentName) {
        if (shouldThrow) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getEmptyError(argumentName));
        }
    }
}
