package de.valor.ranner.persistence.model.training;

import de.valor.ranner.main.validation.arguments.IArgumentValidator;
import de.valor.ranner.main.validation.arguments.StringArgumentValidator;

public class TrainingGroupImpl implements ITrainingGroup {

    private String name;

    private static final IArgumentValidator stringArgValidator = new StringArgumentValidator();


    @Override
    public void setName(String name) {
        stringArgValidator.validateExistsStrict(name, "name");
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
