package de.valor.ranner.persistence.model;

import de.valor.ranner.persistence.model.user.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractEntityTest {

    @Test
    void createImplementation() {
        Admin admin = new Admin();
        assertTrue(admin instanceof AbstractEntity);
    }

    @Test
    void getIdNull() {
        Admin admin = new Admin();
        assertNull(admin.getId());
    }
}