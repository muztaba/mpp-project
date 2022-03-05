package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.controller.AuthorController;
import com.mpp.controller.ControllerFactory;
import com.mpp.exception.ValidationException;
import com.mpp.model.Author;
import com.mpp.model.LibraryMember;
import com.mpp.model.Role;
import com.mpp.utils.UIContext;

import java.util.Scanner;

public class AddAuthor {
    public static void showUI() throws ValidationException {
        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
                .authorizationHandler(Role.LIBRARIAN);

        AuthorController authorController = (AuthorController) ControllerFactory.getController(Author.class);
        System.out.println("Please enter first Name");
        Scanner sc = UIContext.getInstance().getSc();
        String fname = sc.nextLine();
        System.out.println("Please enter Last Name");
        String lname = sc.nextLine();
        System.out.println("Please enter phone Number ");
        int phoneNumber = Integer.parseInt(sc.nextLine());
        System.out.println("Please enter street");
        String street = sc.nextLine();
        System.out.println("Please enter city");
        String city = sc.nextLine();
        System.out.println("Please enter state");
        String state = sc.nextLine();
        System.out.println("Please enter zip");
        int zip = Integer.parseInt(sc.nextLine());
        System.out.println("Please enter Author bio");
        String  bio = sc.nextLine();


        Author author = authorController.createAuthor(fname,lname,phoneNumber,street,city,state,zip,bio);
        System.out.println("Added New Author");
        System.out.println(author);
    }
}
