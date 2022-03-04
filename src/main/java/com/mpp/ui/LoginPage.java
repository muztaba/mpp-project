package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.model.User;
import com.mpp.utils.ApplicationContext;
import com.mpp.utils.Command;
import com.mpp.utils.CommandParser;
import com.mpp.utils.UIContext;

import javax.naming.AuthenticationException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    public static void showUI(UIContext uiContext) {
        Scanner sc = uiContext.getSc();
        CommandParser cp = uiContext.getCp();
        System.out.println("type login to Login and exit for exit");
        while (sc.hasNext()) {
            String cmd = sc.nextLine();
            Command command = cp.parse(cmd);

            switch (command) {
                case EXIT -> {
                    System.out.println("Application exiting...");
                    System.exit(0);
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
            }

        }
    }


}
