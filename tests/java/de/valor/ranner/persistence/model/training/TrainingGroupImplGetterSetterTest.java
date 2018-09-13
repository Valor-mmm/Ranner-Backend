package de.valor.ranner.persistence.model.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrainingGroupImplGetterSetterTest {

    @Test
    void createGroup() {
        new TrainingGroupImpl();
    }

    @Test
    void getName() {
        String name = "Some name €ł@";
        ITrainingGroup trainingGroup = new TrainingGroupImpl();
        trainingGroup.setName(name);
        assertEquals(name, trainingGroup.getName());
    }

    @Test
    void setNameString() {
        String name = "Some valid name €¬[{¬½¼³²";
        ITrainingGroup trainingGroup = new TrainingGroupImpl();
        trainingGroup.setName(name);
        assertEquals(name, trainingGroup.getName());
    }

    @Test
    void setNullString() {
        ITrainingGroup trainingGroup = new TrainingGroupImpl();
        assertThrows(IllegalArgumentException.class, () -> trainingGroup.setName(null));
    }

    @Test
    void setEmptyString() {
        ITrainingGroup trainingGroup = new TrainingGroupImpl();
        assertThrows(IllegalArgumentException.class, () -> trainingGroup.setName(""));
    }

}