package com.mpp.model;

import java.util.List;

public class Librarian extends User {

    public Librarian(String username, String password, List<Role> roles) {
        super(username, password, roles);
    }

}
