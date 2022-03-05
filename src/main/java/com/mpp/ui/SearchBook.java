package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.controller.BookController;
import com.mpp.controller.ControllerFactory;
import com.mpp.model.Book;
import com.mpp.model.Role;
import com.mpp.utils.UIContext;

import java.util.Scanner;

public class SearchBook {
    public static void showUI() {
        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                .authorizationHandler(Role.LIBRARIAN);
        BookController bookController = (BookController)ControllerFactory.getController(Book.class);
        Scanner sc = UIContext.getInstance().getSc();
        System.out.println("Please input Book ISBN");
        String isbn = sc.nextLine();
        Book book = bookController.searchBookByIsbn(isbn);
        System.out.println(book);
    }
}
