package de.valor.ranner.persistence.model.user;

import de.valor.ranner.persistence.model.privileges.Privilege;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AdminGetterSetterTest {

    @Test
    void createAdmin() {
        new Admin();
    }

    @Test
    void getFirstName() {
        String firstName = "";
        AbstractUser abstractUser = new Admin();
        abstractUser.setFirstName(firstName);
        assertEquals(firstName, abstractUser.getFirstName());
    }

    @Test
    void getFirstNameNull() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setFirstName(null);
        assertNull(abstractUser.getFirstName());
    }

    @Test
    void setFirstName() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setFirstName("SomeName");
    }

    @Test
    void setFirstNameNull() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setFirstName(null);
    }

    @Test
    void getPrivilegeList() {
        List<Privilege> privilegesList = new ArrayList<>();
        AbstractUser abstractUser = new Admin();
        abstractUser.setPrivilegeList(privilegesList);
        assertEquals(privilegesList, abstractUser.getPrivilegeList());
    }

    @Test
    void getPrivilegeListNull() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setPrivilegeList(null);
        assertNull(abstractUser.getPrivilegeList());
    }

    @Test
    void setPrivilegeList() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setPrivilegeList(new ArrayList<>());
    }

    @Test
    void setPrivilegeListNull() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setPrivilegeList(null);
    }

    @Test
    void getLastName() {
        String lastName = "@@@'''\"\"²³¼½";
        AbstractUser abstractUser = new Admin();
        abstractUser.setLastName(lastName);
        assertEquals(lastName, abstractUser.getLastName());
    }

    @Test
    void getLastNameNull() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setLastName(null);
        assertNull(abstractUser.getLastName());
    }

    @Test
    void setLastName() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setLastName("");
    }

    @Test
    void setLastNameNull() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setLastName(null);
    }
}