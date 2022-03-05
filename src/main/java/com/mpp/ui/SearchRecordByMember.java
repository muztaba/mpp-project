package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.controller.ControllerFactory;
import com.mpp.controller.LibraryMemberController;
import com.mpp.exception.ValidationException;
import com.mpp.model.CheckoutEntry;
import com.mpp.model.LibraryMember;
import com.mpp.model.Role;
import com.mpp.utils.UIContext;

import java.util.Scanner;

public class SearchRecordByMember {

    public static void showUI() throws ValidationException,NumberFormatException {
        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class)).authorizationHandler(Role.LIBRARIAN);

        LibraryMemberController libraryMemberController = (LibraryMemberController) ControllerFactory.getController(LibraryMember.class);
        System.out.println("Enter library member id");
        Scanner sc = UIContext.getInstance().getSc();
        String memberId = sc.nextLine();

        var checkoutEntries = libraryMemberController.getCheckoutEntriesByLibraryMember(memberId);
        for (CheckoutEntry e : checkoutEntries){
            System.out.println(e);
        }


    }

}
