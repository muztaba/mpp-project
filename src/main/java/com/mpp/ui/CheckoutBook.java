package com.mpp.ui;

import com.mpp.controller.*;
import com.mpp.exception.BookCopyNotAvailableException;
import com.mpp.model.Book;
import com.mpp.model.CheckoutRecord;
import com.mpp.model.LibraryMember;
import com.mpp.model.Role;
import com.mpp.utils.UIContext;

import java.util.Collection;
import java.util.Scanner;

public class CheckoutBook {
    public static void showUI() throws BookCopyNotAvailableException {
        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                .authorizationHandler(Role.LIBRARIAN);
        Collection<LibraryMember> allLibraryMember = ((LibraryMemberController) ControllerFactory
                .getController(LibraryMember.class)).getAllMember();
        for (LibraryMember libraryMember : allLibraryMember) {
            System.out.println(libraryMember);
        }
        Collection<Book> books = ((BookController) ControllerFactory
                .getController(Book.class)).getAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
        CheckoutRecordController checkoutRecordController = (CheckoutRecordController)ControllerFactory.getController(CheckoutRecord.class);
        Scanner sc = UIContext.getInstance().getSc();
        System.out.println("Please Enter member id");
        String memberID = sc.nextLine();
        System.out.println("Please Enter book isbn");
        String isbn = sc.nextLine();
        checkoutRecordController.checkOutBooksForLibraryMembers(memberID,isbn);
        System.out.println("CheckOut Complete");

    }
}
