package com.mpp;

import com.mpp.controller.*;
import com.mpp.exception.BookCopyNotAvailableException;
import com.mpp.model.*;
import com.mpp.serializer.Storage;
import com.mpp.serializer.StorageSerializer;
import com.mpp.ui.LoginPage;
import com.mpp.utils.ApplicationContext;
import com.mpp.utils.CommandParser;
import com.mpp.utils.UIContext;

import java.lang.reflect.Member;
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
        CheckoutRecordController checkoutRecordController = (CheckoutRecordController)ControllerFactory.getController(CheckoutRecord.class);
        try {
            authorController.createAuthor("dan", "Brown", 1234567890, "rasta",
                    "shohor", "rastro", 52557, "Good Writer");
            authorController.createAuthor("paul", "Brown", 1234567890, "1000 n",
                    "fairfeild", "iowa", 52556, "Ok Writer");
            Book book1 = bookController.addNewBook("Inferno", "1234", 7, List.of("dan"));
            Book book2 = bookController.addNewBook("Not Inferno", "1235", 2, List.of("paul"));
            LibraryMember member1 = libraryMemberController.createLibraryMember("Uzbuk", "Jolil",
                    123456, "street", "city", "state", 555555);
            LibraryMember member2 = libraryMemberController.createLibraryMember("Harami", "lname",
                    54321678, "street", "city", "state", 22222);
//            member1.setID("1234");
//            member2.setID("1235");
            checkoutRecordController.createOverdueCheckoutRecord(member1.getID(),book1.getIsbn());
            checkoutRecordController.createOverdueCheckoutRecord(member2.getID(),book2.getIsbn());

        } catch (Exception | BookCopyNotAvailableException e) {
            System.out.println("Matha Karap!");
        }

    }

    public static void main(String[] args) {
        // Application Entry Point
        new App().run();
    }

    public void run() {

        Scanner sc = new Scanner(System.in);
        CommandParser cp = new CommandParser();
        UIContext uiContext = UIContext.getInstance(sc, cp);
        var serializer = new StorageSerializer(storageLocation);
        ApplicationContext.storage = (Storage) serializer.deserialize();

        if (ApplicationContext.storage == null) {
            ApplicationContext.storage = new Storage();
        }
        bootLoader();
        LoginPage.showUI(uiContext);
    }

}
