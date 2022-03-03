package com.mpp.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private final String username;

    private final String password;

    private final List<Role> roles;

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
