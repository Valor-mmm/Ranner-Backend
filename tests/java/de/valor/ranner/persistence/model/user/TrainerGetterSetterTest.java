package de.valor.ranner.persistence.model.user;

import de.valor.ranner.persistence.model.privileges.Privilege;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TrainerGetterSetterTest {

    @Test
    void createAdmin() {
        new Trainer();
    }

    @Test
    void getFirstName() {
        String firstName = "ASDFµ";
        AbstractUser abstractUser = new Trainer();
        abstractUser.setFirstName(firstName);
        assertEquals(firstName, abstractUser.getFirstName());
    }

    @Test
    void getFirstNameNull() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setFirstName(null);
        assertNull(abstractUser.getFirstName());
    }

    @Test
    void setFirstName() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setFirstName("");
    }

    @Test
    void setFirstNameNull() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setFirstName(null);
    }

    @Test
    void getPrivilegeList() {
        List<Privilege> privilegesList = new ArrayList<>();
        AbstractUser abstractUser = new Trainer();
        abstractUser.setPrivilegeList(privilegesList);
        assertEquals(privilegesList, abstractUser.getPrivilegeList());
    }

    @Test
    void getPrivilegeListNull() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setPrivilegeList(null);
        assertNull(abstractUser.getPrivilegeList());
    }

    @Test
    void setPrivilegeList() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setPrivilegeList(new ArrayList<>());
    }

    @Test
    void setPrivilegeListNull() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setPrivilegeList(null);
    }

    @Test
    void getLastName() {
        String lastName = "";
        AbstractUser abstractUser = new Trainer();
        abstractUser.setLastName(lastName);
        assertEquals(lastName, abstractUser.getLastName());
    }

    @Test
    void getLastNameNull() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setLastName(null);
        assertNull(abstractUser.getLastName());
    }

    @Test
    void setLastName() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setLastName("@@@µ²²²³ßß");
    }

    @Test
    void setLastNameNull() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setLastName(null);
    }

}