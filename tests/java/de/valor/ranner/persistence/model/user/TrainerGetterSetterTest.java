package de.valor.ranner.persistence.model.user;

import de.valor.ranner.persistence.model.privileges.Privilege;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void getEmail() {
        String someEmail = "this@validMail.gr";
        Trainer trainer = new Trainer();
        trainer.setEmail(someEmail);
        assertEquals(someEmail, trainer.getEmail());

    }

    @Test
    void getEmailInitial() {
        Trainer trainer = new Trainer();
        assertNull(trainer.getEmail());
    }

    @Test
    void setEmailValid() {
        Trainer trainer = new Trainer();
        trainer.setEmail("some@mail.us");
    }

    @Test
    void setEmailNull() {
        Trainer trainer = new Trainer();
        assertThrows(IllegalArgumentException.class,
                () -> trainer.setEmail(null)
        );
    }

    @Test
    void setEmailInvalidShort() {
        Trainer trainer = new Trainer();
        assertThrows(IllegalArgumentException.class, () -> trainer.setEmail("really@Not@valid.com"));
    }

    @Test
    void setEmailInvalidMissingAt() {
        Trainer trainer = new Trainer();
        assertThrows(IllegalArgumentException.class, () -> trainer.setEmail("inv alid@Mail.com"));
    }

    @Test
    void setEmailInvalidWrongDomain() {
        Trainer trainer = new Trainer();
        assertThrows(IllegalArgumentException.class, () -> trainer.setEmail("invalid@do-main.if"));
    }

}