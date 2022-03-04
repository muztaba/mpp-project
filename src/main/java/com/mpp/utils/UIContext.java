package com.mpp.utils;

import com.mpp.model.User;

import java.util.Scanner;

public class UIContext {


    private final CommandParser cp;
    private final Scanner sc;
    private static UIContext uiInstance;
    private UIContext(Scanner sc, CommandParser cp) {
        this.sc = sc;
        this.cp = cp;
    }

    public static UIContext getInstance(Scanner sc, CommandParser cp){
        if (uiInstance == null){
            uiInstance = new UIContext(sc, cp);
        }
        return uiInstance;

    }

    public static UIContext getInstance(){
        if (uiInstance == null){
            throw new NullPointerException();
        }
        return uiInstance;
    }


    public CommandParser getCp() {
        return cp;
    }

    public Scanner getSc() {
        return sc;
    }
}
