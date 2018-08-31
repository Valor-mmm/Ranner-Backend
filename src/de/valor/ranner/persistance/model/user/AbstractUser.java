package de.valor.ranner.persistance.model.user;

import de.valor.ranner.persistance.model.privileges.Privilege;

import java.util.List;

public class AbstractUser {

    private String firstName;

    private String lastName;

    private List<Privilege> privilegeList;


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
}
