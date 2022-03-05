package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.controller.ControllerFactory;
import com.mpp.controller.LibraryMemberController;
import com.mpp.model.LibraryMember;
import com.mpp.model.Role;
import com.mpp.utils.UIContext;

import java.util.Scanner;

public class SearchMember {
    public static void showUI() {
//        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class))
//                .authorizationHandler(Role.LIBRARIAN);

        LibraryMemberController libraryMemberController = (LibraryMemberController) ControllerFactory.getController(LibraryMember.class);
        Scanner sc = UIContext.getInstance().getSc();
        System.out.println("Please enter the member ID");
        String memberUUID = sc.nextLine();
        LibraryMember libraryMember = libraryMemberController.searchMemberByID(memberUUID);
        System.out.println(libraryMember);

    }
}
