package com.mpp;

import com.mpp.model.Role;
import com.mpp.model.User;
import com.mpp.serializer.Storage;
import com.mpp.serializer.StorageSerializer;
import com.mpp.ui.LoginPage;
import com.mpp.utils.ApplicationContext;
import com.mpp.utils.CommandParser;
import com.mpp.utils.UIContext;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.mpp.ui.LoginPage.storageLocation;

public class App {

    public static final Map<String, User> userMap = Map.of(
            "123",
            new User("admin", "admin", List.of(Role.ADMIN, Role.LIBRARIAN)),
            "124",
            new User("library", "library", List.of(Role.LIBRARIAN)),
            "125",
            new User("admin1","admin", List.of(Role.ADMIN))
    );

    public static void main(String[] args) {
        // Application Entry Point
        new App().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        CommandParser cp = new CommandParser();
        UIContext uiContext = UIContext.getInstance(sc,cp);
        var serializer = new StorageSerializer(storageLocation);
        ApplicationContext.storage = (Storage) serializer.deserialize();

        if (ApplicationContext.storage == null) {
            ApplicationContext.storage = new Storage();
        }

        LoginPage.showUI(uiContext);
    }

}
