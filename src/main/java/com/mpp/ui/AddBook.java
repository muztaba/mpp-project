package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.controller.BookController;
import com.mpp.controller.ControllerFactory;
import com.mpp.exception.ValidationException;
import com.mpp.model.Book;
import com.mpp.model.Role;
import com.mpp.utils.UIContext;
import com.mpp.validation.ValidatorUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddBook {


    public static void showUI() throws ValidationException, NumberFormatException {
        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class)).authorizationHandler(Role.ADMIN);

        BookController bookController = (BookController) ControllerFactory.getController(Book.class);
        System.out.println("Please enter the title of the Book");
        Scanner sc = UIContext.getInstance().getSc();
        String title = sc.nextLine();
        System.out.println("Please enter the isbn of the Book");
        String isbn = sc.nextLine();
        System.out.println("Please enter the borrow duration of the Book");
        Integer borrowDurationInDays = Integer.parseInt(sc.nextLine());
        System.out.println("Please enter the author Names ");
        List<String> authorNames = new ArrayList<>();
        String authorName = sc.nextLine();
        ValidatorUtility.isValidString(authorName);
        authorNames.add(authorName);
        while (true) {
            System.out.println("To add more authors press 0, to stop press 1");
            int nextPoint = Integer.parseInt(sc.nextLine());
            if (nextPoint == 1) {
                break;
            } else if (nextPoint == 0) {
                authorName = sc.nextLine();
                try {
                    ValidatorUtility.isValidString(authorName);
                    authorNames.add(authorName);
                } catch (ValidationException wrongInput) {
                    wrongInput.printStackTrace();
                    System.out.println("Invalid author Name! Try Again!");
                }
            } else {
                System.out.println("Wrong input!");
            }
        }
        Book book = bookController.addNewBook(title, isbn, borrowDurationInDays, authorNames);

        System.out.println("Added Book");
        System.out.println(book);
    }
}
