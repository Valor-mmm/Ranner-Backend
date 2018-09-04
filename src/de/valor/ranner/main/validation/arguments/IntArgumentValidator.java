package de.valor.ranner.main.validation.arguments;

public class IntArgumentValidator implements IArgumentValidator {

    private static final String type = "Integer";

    private static final String typeError = "Given parameter is not of type: " + type;

    private static final String notExistsError = "The given parameter is null or empty.";

    @Override
    public boolean validateExists(Object target) {
        boolean correctType = this.validateType(target);
        return correctType && this.checkExists(target);
    }

    @Override
    public boolean validateExistsStrict(Object target) {
        boolean validType = this.validateTypeStrict(target);
        return validType && this.checkExistsStrict(target);
    }

    @Override
    public boolean validateType(Object target) {
        boolean result = false;

        if (target instanceof Integer) {
            result = true;
        }

        return result;
    }

    @Override
    public boolean validateTypeStrict(Object target) {
        boolean validType = this.validateType(target);
        this.throwTypeError(!validType);
        return validType;

    }

    @Override
    public boolean checkExists(Object target) {
        return target == null;
    }

    @Override
    public boolean checkExistsStrict(Object target) {
        boolean doesExist = this.checkExists(target);
        this.throwNotExistsError(!doesExist);
        return doesExist;
    }

    private void throwTypeError(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException(typeError);
        }
    }

    private void throwNotExistsError(boolean shouldThrow) {
        if (shouldThrow) {
            throw new IllegalArgumentException(notExistsError);
        }
    }

}
