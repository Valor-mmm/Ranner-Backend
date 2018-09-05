package de.valor.ranner.main.validation.arguments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringArgumentValidator implements IArgumentValidator {

    private static final String type = "String";

    private static final Logger logger = LogManager.getLogger(StringArgumentValidator.class);

    @Override
    public boolean validateType(Object target) {
        return target instanceof String;
    }

    @Override
    public void validateTypeStrict(Object target) {
        if (!(target instanceof String)) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getTypeError(type));
        }
    }

    @Override
    public boolean checkExists(Object target) {
        boolean result = !this.isNull(target);
        result = result && this.validateType(target);
        return result && !this.isEmpty((String) target);
    }

    @Override
    public void checkExistsStrict(Object target) {
        this.isNullStrict(target);
        this.validateTypeStrict(target);
        this.isEmptyStrict(target);
    }

    @Override
    public void logValidationResult(boolean result) {
        logger.info(ArgumentLogStringGenerator.getValidateExistResult(result));
    }

    private void isNullStrict(Object target) {
        if (target == null) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getNullError());
        }
    }

    private void isEmptyStrict(Object target) {
        this.isNullStrict(target);
        boolean isEmpty = isEmpty((String) target);
        this.throwEmptyError(isEmpty);
    }

    private boolean isEmpty (String target) {
        boolean isNull = this.isNull(target);
        return !isNull && target.isEmpty();
    }

    private boolean isNull (Object target) {
        return target == null;
    }

    private void throwEmptyError(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException(ArgumentLogStringGenerator.getEmptyError());
        }
    }
}
