package com.mpp.controller;

import com.mpp.App;
import com.mpp.model.Role;
import com.mpp.model.User;
import com.mpp.ui.LoginPage;
import com.mpp.utils.ApplicationContext;
import com.mpp.utils.UIContext;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.util.Map;

public class AuthenticationController implements DomainController {

    public User authenticate(String username, String password) throws AuthenticationException {
        for (Map.Entry<String, User> k : App.userMap.entrySet()) {
            User user = k.getValue();
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new AuthenticationException("Failed to login");
    }

    public void logout(){
        ApplicationContext.setUser(null);
        LoginPage.showUI(UIContext.getInstance());
    }

    public void hasPermission(User user, Role role) throws AccessDeniedException {
        boolean flag = user.getRoles().contains(role);
        if (!flag) throw new AccessDeniedException("You have no access here!");
    }


}
