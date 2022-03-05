package com.mpp.ui;

import com.mpp.controller.AuthenticationController;
import com.mpp.controller.ControllerFactory;
import com.mpp.exception.ValidationException;
import com.mpp.model.Role;
import com.mpp.model.User;
import com.mpp.utils.*;

import java.util.Scanner;

public class UserMenu {


    private static void printDirections(User user) {
        System.out.println("Use the following number list for below");
        if (user.getRoles().contains(Role.ADMIN)) {
            System.out.println(" 1. Add new Book \n 2. Create new Library member \n 3. Edit Library member");
        }
        if (user.getRoles().contains(Role.LIBRARIAN)) {
            System.out.println(" 4. Search Member By ID \n 5. Get Checkout Records by Members \n 6. Search Book by ISBN \n " +
                    "7. Get All Overdue Books \n 8. Get Total Fine for all Library Member \n 9. Get All Checkout Entries" +
                    " \n 10. Get All overdue Entries \n 11. Checkout Book");
        }

        System.out.println(" 12. Logout");
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
                    case 5: SearchBook.showUI();
                            break;
                    case 6:
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
                        break;
                    case 12:
                        System.out.println("Logging out!");
                        ((AuthenticationController) ControllerFactory.getController(AuthenticationController.class)).logout();
                        break;

                }
            } catch (ValidationException | NumberFormatException wrongInput) {
                wrongInput.printStackTrace();
                UserMenu.showUI(uiContext);
            }
            printDirections(user);
        }


    }
}
