package com.mpp.ui;

import com.mpp.controller.*;
import com.mpp.exception.BookCopyNotAvailableException;
import com.mpp.exception.ValidationException;
import com.mpp.model.*;
import com.mpp.utils.ApplicationContext;
import com.mpp.utils.CommandParser;
import com.mpp.utils.UIContext;

import java.util.Collection;
import java.util.Scanner;

public class UserMenu {


    private static void printDirections(User user) {
        System.out.println("Use the following number list for below");
        if (user.getRoles().contains(Role.ADMIN)) {
            System.out.println(" 1. Add new Book \n " +
                    "2. Create new Library member \n " +
                    "3. Edit Library member");
        }
        System.out.println(" 4. Search Member By ID ");
        if (user.getRoles().contains(Role.LIBRARIAN)) {
            System.out.println(
                    " 5. Get Checkout Records by Members \n " +
                            "6. Search Book by ISBN \n " +
                            "7. Get All Overdue Books \n " +
                            "8. Get Total Fine for all Library Member \n " +
                            "9. Get All Checkout Entries\n " +
                            "10. Get All overdue Entries \n " +
                            "11. Checkout Book");
        }
        System.out.println(
                " 12. Get All members");
        if (user.getRoles().contains(Role.LIBRARIAN)) {
            System.out.println(
                    " 13. Get All Books\n " +
                            "14. Get All Authors \n " +
                            "15. Add Authors "
                            );
        }

        if (user.getRoles().contains(Role.ADMIN)) {
            System.out.println(" 16. Add new Copy of Book");
        }



        System.out.println(" 17. Logout");
    }


    public static void showUI(UIContext uiContext) {
        User user = ApplicationContext.getUser();


        Scanner sc = uiContext.getSc();
        CommandParser cp = uiContext.getCp();
        printDirections(user);
        while (sc.hasNext()) {

            int cmd = Integer.parseInt(sc.nextLine());

            //TODO: need connect everything to the UI also make authentication as well

            try {
                //                        Get All library member
                //                        Get All Books
                //                        Get All Authors
                switch (cmd) {
                    case 1 -> AddBook.showUI();
                    case 2 -> AddLibraryMember.showUI();
                    case 3 -> EditLibraryMember.showUI();
                    case 4 -> SearchMember.showUI();
                    case 5 -> SearchRecordByMember.showUI();
                    case 6 -> SearchBook.showUI();
                    case 7 -> {
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                                .authorizationHandler(Role.LIBRARIAN);
                        float sum = 0.0f;
                        var allOverDueBooks = ((CheckoutRecordController) ControllerFactory.getController(CheckoutRecord.class))
                                .getAllOverdueEntries();
                        for (var it : allOverDueBooks) {
                            sum += it.getFine();
                            System.out.println(it);
                        }
                        System.out.println("Total fine = " + sum);
                    }
                    case 8 -> {
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                                .authorizationHandler(Role.LIBRARIAN);
                        float fineSum = 0.0f;
                        var allOverDueBookList = ((CheckoutRecordController) ControllerFactory.getController(CheckoutRecord.class))
                                .getAllOverdueEntries();
                        for (var it : allOverDueBookList) {
                            fineSum += it.getFine();
//                            System.out.println(it);
                        }
                        System.out.println("Total fine = " + fineSum);
                    }
                    case 9 -> {
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                                .authorizationHandler(Role.LIBRARIAN);
                        var allCheckoutEntries = ((CheckoutRecordController) ControllerFactory.getController(CheckoutRecord.class))
                                .getAllCheckoutEntries();
                        for (var it : allCheckoutEntries) {
//                            fineSum += it.getFine();
                            System.out.println(it);
                        }
                    }
                    case 10 -> {
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                                .authorizationHandler(Role.LIBRARIAN);
                        var allOverdueEntries = ((CheckoutRecordController) ControllerFactory.getController(CheckoutRecord.class))
                                .getAllOverdueEntries();
                        for (var it : allOverdueEntries) {
//                            fineSum += it.getFine();
                            System.out.println(it);
                        }
                    }
                    case 11 -> CheckoutBook.showUI();
                    case 12 -> {
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                                .authorizationHandler(Role.LIBRARIAN);
                        Collection<LibraryMember> allLibraryMember = ((LibraryMemberController) ControllerFactory
                                .getController(LibraryMember.class)).getAllMember();
                        for (LibraryMember libraryMember : allLibraryMember) {
                            System.out.println(libraryMember);
                        }
                    }
                    case 13 -> {
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                                .authorizationHandler(Role.LIBRARIAN);
                        Collection<Book> books = ((BookController) ControllerFactory
                                .getController(Book.class)).getAllBooks();
                        for (Book book : books) {
                            System.out.println(book);
                        }
                    }
                    case 14 -> {
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                                .authorizationHandler(Role.LIBRARIAN);
                        Collection<Author> authors = ((AuthorController) ControllerFactory
                                .getController(Author.class)).getAllAuthor();
                        for (Author author : authors) {
                            System.out.println(author);
                        }
                    }
                    case 15 -> AddAuthor.showUI();
                    case 16 -> AddBookCopy.showUI();
                    case 17 -> {
                        System.out.println("Logging out!");
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class)).logout();
                    }
                }
            } catch (ValidationException | NumberFormatException wrongInput) {
                wrongInput.printStackTrace();
                UserMenu.showUI(uiContext);
            } catch (Exception e) {
                System.out.println("OOPS SOMETHING WENT WRONG!");
                UserMenu.showUI(uiContext);
            } catch (BookCopyNotAvailableException bookCopyNotAvailableException){
                System.out.println("Book not found");
            }
            printDirections(user);
        }


    }
}
