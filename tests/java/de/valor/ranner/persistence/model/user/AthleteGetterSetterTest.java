package de.valor.ranner.persistence.model.user;

import de.valor.ranner.persistence.model.privileges.Privilege;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AthleteGetterSetterTest {

    @Test
    void createAthlete() {
        new Athlete();
    }

    @Test
    void getFirstName() {
        String firstName = "";
        AbstractUser abstractUser = new Athlete();
        abstractUser.setFirstName(firstName);
        assertEquals(firstName, abstractUser.getFirstName());
    }

    @Test
    void getFirstNameNull() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setFirstName(null);
        assertNull(abstractUser.getFirstName());
    }

    @Test
    void setFirstName() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setFirstName("·′¹′′^^°°@µ");
    }

    @Test
    void setFirstNameNull() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setFirstName(null);
    }

    @Test
    void getPrivilegeList() {
        List<Privilege> privilegesList = new ArrayList<>();
        AbstractUser abstractUser = new Athlete();
        abstractUser.setPrivilegeList(privilegesList);
        assertEquals(privilegesList, abstractUser.getPrivilegeList());
    }

    @Test
    void getPrivilegeListNull() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setPrivilegeList(null);
        assertNull(abstractUser.getPrivilegeList());
    }

    @Test
    void setPrivilegeList() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setPrivilegeList(new ArrayList<>());
    }

    @Test
    void setPrivilegeListNull() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setPrivilegeList(null);
    }

    @Test
    void getLastName() {
        String lastName = "ßßßßß";
        AbstractUser abstractUser = new Athlete();
        abstractUser.setLastName(lastName);
        assertEquals(lastName, abstractUser.getLastName());
    }

    @Test
    void getLastNameNull() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setLastName(null);
        assertNull(abstractUser.getLastName());
    }

    @Test
    void setLastName() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setLastName("");
    }

    @Test
    void setLastNameNull() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setLastName(null);
    }

}