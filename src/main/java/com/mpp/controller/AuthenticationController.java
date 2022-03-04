package com.mpp.controller;

import com.mpp.App;
import com.mpp.model.User;

import javax.naming.AuthenticationException;
import java.util.Map;

public class AuthenticationController {

    public User authenticate(String username, String password) throws AuthenticationException {
        for (Map.Entry<String, User> k : App.userMap.entrySet()) {
            User user = k.getValue();
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new AuthenticationException("Failed to login");
    }
}
