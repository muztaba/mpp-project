package com.mpp;

import com.mpp.controller.AuthenticationController;
import com.mpp.model.Administrator;
import com.mpp.model.Role;
import com.mpp.model.User;
import com.mpp.utils.ApplicationContext;
import com.mpp.utils.Command;
import com.mpp.utils.CommandParser;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class App {

    public static final Map<String, User> userMap = Map.of(
            "123",
            new Administrator("admin", "admin", List.of(Role.ADMIN, Role.LIBRARIAN))
    );

    public static void main(String[] args) {
        // Application Entry Point
        new App().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        CommandParser cp = new CommandParser();

        while (sc.hasNext()) {
            String cmd = sc.nextLine();
            Command command = cp.parse(cmd);

            switch (command) {
                case EXIT:
                    System.out.println("Application exiting...");
                    System.exit(0);
                    break;
                case LOGIN:
                    System.out.println("Please enter username");
                    String username = sc.nextLine();
                    System.out.println("Please enter password");
                    String password = sc.nextLine();
                    User user;
                    try {
                        user = new AuthenticationController().authenticate(username,password);
                    } catch (AuthenticationException e) {
                        e.printStackTrace();
                        System.out.println("Login failed !");
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        break;
                    }

                    break;
            }

        }
    }

}
