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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EditLibraryMember {
    public static void showUI() throws ValidationException, NumberFormatException {
        try {
            ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class)).hasPermission(ApplicationContext.getUser(), Role.ADMIN);
        } catch (AccessDeniedException e) {
            e.printStackTrace();
            System.out.println("Access Denied! You have no Power Here!");
            UserMenu.showUI(UIContext.getInstance());
        }

        LibraryMemberController libraryMemberController = ControllerFactory.getLibraryMemberController();

        Collection<LibraryMember> allLibraryMember = libraryMemberController.getAllMember();
        for (LibraryMember libraryMember : allLibraryMember) {
            System.out.println(libraryMember);
        }


        System.out.println("Please enter the Library Member You want to Edit!");
        Scanner sc = UIContext.getInstance().getSc();
        String library_uuid = sc.nextLine();
        System.out.println("Please enter first Name");
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

        libraryMemberController.editLibraryMember(library_uuid, fname, lname, phoneNumber, street, city, state, zip);


    }
}
