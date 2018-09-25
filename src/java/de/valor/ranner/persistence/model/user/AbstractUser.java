package de.valor.ranner.persistence.model.user;

import de.valor.ranner.main.validation.arguments.EmailArgumentValidator;
import de.valor.ranner.main.validation.arguments.IArgumentValidator;
import de.valor.ranner.persistence.model.AbstractEntity;
import de.valor.ranner.persistence.model.privileges.Privilege;

import java.time.LocalDateTime;
import java.util.List;

public abstract class AbstractUser extends AbstractEntity {

    private String firstName;

    private String lastName;

    private List<Privilege> privilegeList;

    private LocalDateTime birthday;

    private String email;

    private static final IArgumentValidator emailArgValidator = new EmailArgumentValidator();


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        emailArgValidator.validateExistsStrict(email, "email");
        this.email = email;
    }
}
