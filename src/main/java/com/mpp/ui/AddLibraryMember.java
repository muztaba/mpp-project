package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.controller.ControllerFactory;
import com.mpp.controller.LibraryMemberController;
import com.mpp.exception.ValidationException;
import com.mpp.model.LibraryMember;
import com.mpp.model.Role;
import com.mpp.utils.ApplicationContext;
import com.mpp.utils.UIContext;

import java.nio.file.AccessDeniedException;
import java.util.Scanner;

public class AddLibraryMember {


    public static void showUI() throws NumberFormatException, ValidationException {
        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class)).authenticationHandler(Role.ADMIN);

        LibraryMemberController libraryMemberController = (LibraryMemberController) ControllerFactory.getController(LibraryMember.class);
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


        LibraryMember libraryMember = libraryMemberController.createLibraryMember(fname,lname,phoneNumber,street,city,state,zip);
        System.out.println("Added New Library Member");
        System.out.println(libraryMember);
    }
}
