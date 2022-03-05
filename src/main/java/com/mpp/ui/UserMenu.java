package com.mpp.ui;

import com.mpp.controller.*;
import com.mpp.exception.BookCopyNotAvailableException;
import com.mpp.exception.ValidationException;
import com.mpp.model.*;
import com.mpp.utils.*;

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
                            "15. Add Authors");
        }


        System.out.println(" 16. Logout");
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
                switch (cmd) {
                    case 1:
                        AddBook.showUI();
                        break;
                    case 2:
                        AddLibraryMember.showUI();
                        break;
                    case 3:
                        EditLibraryMember.showUI();
                        break;
                    case 4:
                        SearchMember.showUI();
                        break;
                    case 5:
                        break;
                    case 6:
                        SearchBook.showUI();
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        CheckoutBook.showUI();
                        break;
                    case 12:
//                        Get All library member
                        Collection<LibraryMember> allLibraryMember = ((LibraryMemberController) ControllerFactory
                                .getController(LibraryMember.class)).getAllMember();
                        for (LibraryMember libraryMember : allLibraryMember) {
                            System.out.println(libraryMember);
                        }
                        break;
                    case 13:
//                        Get All Books
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                                .authorizationHandler(Role.LIBRARIAN);
                        Collection<Book> books = ((BookController) ControllerFactory
                                .getController(Book.class)).getAllBooks();
                        for (Book book : books) {
                            System.out.println(book);
                        }
                        break;
                    case 14:
//                        Get All Authors
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                                .authorizationHandler(Role.LIBRARIAN);
                        Collection<Author> authors = ((AuthorController) ControllerFactory
                                .getController(Author.class)).getAllAuthor();
                        for (Author author : authors) {
                            System.out.println(author);
                        }
                        break;
                    case 15:
                        AddAuthor.showUI();
                        break;
                    case 16:
                        System.out.println("Logging out!");
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class)).logout();
                        break;

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
