package com.mpp;

import com.mpp.controller.AuthorController;
import com.mpp.controller.BookController;
import com.mpp.controller.ControllerFactory;
import com.mpp.controller.LibraryMemberController;
import com.mpp.model.*;
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
            new User("admin1", "admin", List.of(Role.ADMIN))
    );


    public static void bootLoader() {
        AuthorController authorController = (AuthorController) ControllerFactory.getController(Author.class);
        BookController bookController = (BookController) ControllerFactory.getController(Book.class);
        LibraryMemberController libraryMemberController = (LibraryMemberController) ControllerFactory.getController(LibraryMember.class);
        try {
            authorController.createAuthor("dan", "Brown", 1234567890, "rasta",
                    "shohor", "rastro", 52557, "Good Writer");
            authorController.createAuthor("paul", "Brown", 1234567890, "1000 n",
                    "fairfeild", "iowa", 52556, "Ok Writer");
            bookController.addNewBook("Inferno", 1234, 7, List.of("dan"));
            bookController.addNewBook("Not Inferno", 1235, 21, List.of("paul"));
            libraryMemberController.createLibraryMember("Uzbuk", "Jolil", 0987654, "street", "city", "state", 555555);
            libraryMemberController.createLibraryMember("Harami", "lname", 54321678, "street", "city", "state", 22222);
        } catch (Exception e) {
            System.out.println("Matha Karap!");
        }

    }

    public static void main(String[] args) {
        // Application Entry Point
        new App().run();
    }

    public void run() {
        bootLoader();
        Scanner sc = new Scanner(System.in);
        CommandParser cp = new CommandParser();
        UIContext uiContext = UIContext.getInstance(sc, cp);
        var serializer = new StorageSerializer(storageLocation);
        ApplicationContext.storage = (Storage) serializer.deserialize();

        if (ApplicationContext.storage == null) {
            ApplicationContext.storage = new Storage();
        }

        LoginPage.showUI(uiContext);
    }

}
