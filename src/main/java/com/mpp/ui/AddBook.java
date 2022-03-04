package com.mpp.ui;

import com.mpp.controller.BookController;
import com.mpp.controller.ControllerFactory;
import com.mpp.model.Author;
import com.mpp.model.Book;
import com.mpp.utils.UIContext;
import com.mpp.utils.Validator;
import com.mpp.utils.WrongInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddBook {


    public static void showUI() throws WrongInput {
        BookController bookController = ControllerFactory.getBookController();
        System.out.println("Please enter the title of the Book");
        Scanner sc = UIContext.getInstance().getSc();
        String title = sc.nextLine();
        System.out.println("Please enter the isbn of the Book");
        String isbn = sc.nextLine();
        System.out.println("Please enter the author Names ");
        List<String> authorNames = new ArrayList<>();
        String authorName = sc.nextLine();
        Validator.isValidString(authorName);
        authorNames.add(authorName);
        while(true){
            System.out.println("To add more authors press 0, to stop press 1");
            int nextPoint = Integer.parseInt(sc.nextLine());
            if (nextPoint == 1){
                break;
            }else if(nextPoint == 0){
                authorName = sc.nextLine();
                try {
                    Validator.isValidString(authorName);
                    authorNames.add(authorName);
                }catch (WrongInput wrongInput){
                    wrongInput.printStackTrace();
                    System.out.println("Invalid author Name! Try Again!");
                }
            }
            else {
                System.out.println("Wrong input!");
            }
        }
        Book book = null;
        try {
            book = bookController.addNewBook(title, isbn, authorNames);
        } catch (WrongInput wrongInput) {
            wrongInput.printStackTrace();
            System.out.println("Invalid Inputs! Please start from beginning!");
        }
        System.out.println("Added Book");
        System.out.println(book);
    }
}
