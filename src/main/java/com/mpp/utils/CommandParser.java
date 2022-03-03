package com.mpp.utils;

public class CommandParser {

    public Command parse(String cmd) {
        String a[] = cmd.split(" ");

        String str = a[0].toUpperCase();

        return Command.valueOf(str);
    }

}
