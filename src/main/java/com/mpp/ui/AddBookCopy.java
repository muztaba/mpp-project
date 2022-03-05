package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.controller.BookController;
import com.mpp.controller.ControllerFactory;
import com.mpp.model.Book;
import com.mpp.model.Role;
import com.mpp.utils.UIContext;

import java.util.Collection;
import java.util.Scanner;

public class AddBookCopy {
    public static void showUI() {

        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                .authorizationHandler(Role.ADMIN);

        BookController bookController = (BookController) ControllerFactory.getController(Book.class);
        Scanner sc = UIContext.getInstance().getSc();

        Collection<Book> books = bookController.getAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("Enter Book isbn");
        String isbn = sc.nextLine();
        bookController.addNewBookCopy(isbn);


    }
}
