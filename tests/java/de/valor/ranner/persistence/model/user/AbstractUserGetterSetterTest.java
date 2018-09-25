package de.valor.ranner.persistence.model.user;

import de.valor.ranner.persistence.model.privileges.Privilege;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractUserGetterSetterTest {

    @Test
    void getFirstName() {
        String firstName = "Norbert";
        AbstractUser abstractUser = new Trainer();
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
        AbstractUser abstractUser = new Admin();
        abstractUser.setFirstName("Robert");
    }

    @Test
    void setFirstNameNull() {
        AbstractUser abstractUser = new Trainer();
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
        AbstractUser abstractUser = new Admin();
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
        AbstractUser abstractUser = new Athlete();
        abstractUser.setPrivilegeList(null);
    }

    @Test
    void getLastName() {
        String lastName = "Frankenstein";
        AbstractUser abstractUser = new Admin();
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
        AbstractUser abstractUser = new Athlete();
        abstractUser.setLastName("LastNameAndSo");
    }

    @Test
    void setLastNameNull() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setLastName(null);
    }

    @Test
    void getBirthday() {
        LocalDateTime localDateTime = LocalDateTime.now();
        AbstractUser abstractUser = new Trainer();
        abstractUser.setBirthday(localDateTime);
        assertEquals(localDateTime, abstractUser.getBirthday());
    }

    @Test
    void getBirthdayNull() {
        AbstractUser abstractUser = new Admin();
        abstractUser.setBirthday(null);
        assertNull(abstractUser.getBirthday());
    }

    @Test
    void setBirthdayMax() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setBirthday(LocalDateTime.MAX);
    }

    @Test
    void setBirthdayMin() {
        AbstractUser abstractUser = new Trainer();
        abstractUser.setBirthday(LocalDateTime.MIN);
    }

    @Test
    void setBirthdayNull() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setBirthday(null);
    }

    @Test
    void getEmail() {
        String someEmail = "thisMail@isValid.at";
        AbstractUser abstractUser = new Trainer();
        abstractUser.setEmail(someEmail);
        assertEquals(someEmail, abstractUser.getEmail());

    }

    @Test
    void getEmailInitial() {
        AbstractUser abstractUser = new Admin();
        assertNull(abstractUser.getEmail());
    }

    @Test
    void setEmailValid() {
        AbstractUser abstractUser = new Athlete();
        abstractUser.setEmail("a@valid-mail.com");
    }

    @Test
    void setEmailNull() {
        AbstractUser abstractUser = new Trainer();
        assertThrows(IllegalArgumentException.class,
                () -> abstractUser.setEmail(null)
        );
    }

    @Test
    void setEmailInvalidShort() {
        AbstractUser abstractUser = new Athlete();
        assertThrows(IllegalArgumentException.class, () -> abstractUser.setEmail("not@valid."));
    }

    @Test
    void setEmailInvalidMissingAt() {
        AbstractUser abstractUser = new Admin();
        assertThrows(IllegalArgumentException.class, () -> abstractUser.setEmail("invalidMail.com"));
    }

    @Test
    void setEmailInvalidWrongDomain() {
        AbstractUser abstractUser = new Athlete();
        assertThrows(IllegalArgumentException.class, () -> abstractUser.setEmail("invalid@domain.qwertzuiop"));
    }
}