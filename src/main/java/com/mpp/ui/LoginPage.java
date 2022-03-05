package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.model.User;
import com.mpp.serializer.Storage;
import com.mpp.serializer.StorageSerializer;
import com.mpp.utils.ApplicationContext;
import com.mpp.utils.Command;
import com.mpp.utils.CommandParser;
import com.mpp.utils.UIContext;

import javax.naming.AuthenticationException;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    private static final String storageLocation = "storage/db.bin";

    public static void showUI(UIContext uiContext) {
        Scanner sc = uiContext.getSc();
        CommandParser cp = uiContext.getCp();
        System.out.println("type login to Login and exit for exit");

        var serializer = new StorageSerializer(storageLocation);
        var storage = (Storage) serializer.deserialize();
        ApplicationContext.serializer = serializer;
        ApplicationContext.storage = storage;

        while (sc.hasNext()) {
            String cmd = sc.nextLine();
            Command command = cp.parse(cmd);

            switch (command) {
                case EXIT -> {
                    serializer.serialize(storage);
                    System.exit(1);
                }
                case LOGIN -> {
                    System.out.println("Please enter username");
                    String username = sc.nextLine();
                    System.out.println("Please enter password");
                    String password = sc.nextLine();
                    User user;
                    try {
                        user = new AuthenticationController().authenticate(username, password);
                        ApplicationContext.setUser(user);
                        UserMenu.showUI(uiContext);
                    } catch (AuthenticationException e) {
                        e.printStackTrace();
                        System.out.println("Login failed !");
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }

                    }
                }
                default -> System.out.println("Wrong Input!");

            }

        }

    }


}
