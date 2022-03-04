package com.mpp.utils;

import com.mpp.controller.AuthenticationController;
import com.mpp.model.User;

public class ApplicationContext {
    public static final String OPERATION_LOGIN = "LOGIN";
    public static final String OPERATION_ADD_BOOK = "ADD_BOOK";
    public static AuthenticationController authenticationController;
    static User user;

    public static User getUser(){
        return user;
    }

    public static AuthenticationController getAuthenticationConroller() {
        return authenticationController;
    }


    public static void setUser(User user) {
        ApplicationContext.user = user;
    }
}
