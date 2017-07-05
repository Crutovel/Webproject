package com.softserve.edu.webproject.entity;

import javax.persistence.*;
import java.io.Serializable;


@NamedQuery(name = Account.QUERY_FIND_BY_USER_NAME,
        query = "select a from Account a where a.userName = :" + Account.PARAM_USER_NAME)
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    private static final long serialVersionUID = -2054386655979281969L;
    public static final String QUERY_FIND_BY_USER_NAME = "Account.findByUserName";
    public static final String PARAM_USER_NAME = "userName";

    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";

    private String userName;
    private String password;
    private boolean active;
    private String userRole;

    @Id
    @Column(name = "user_name", length = 20, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "password", length = 20, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "active", length = 1, nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Column(name = "User_Role", length = 20, nullable = false)
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "[" + this.userName + "," + this.password + "," + this.userRole + "]";
    }

}
