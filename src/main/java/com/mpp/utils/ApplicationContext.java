package com.mpp.utils;

import com.mpp.controller.AuthenticationController;
import com.mpp.model.User;
import com.mpp.serializer.Storage;

public class ApplicationContext {
    public static final String OPERATION_LOGIN = "LOGIN";
    public static final String OPERATION_ADD_BOOK = "ADD_BOOK";
    static User user;

    public static Storage storage;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        ApplicationContext.user = user;
    }
}
