package com.mpp;

import com.mpp.utils.Command;
import com.mpp.utils.CommandParser;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Application Entry Point
        new App().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        CommandParser cp = new CommandParser();

        while (sc.hasNext()) {
            String cmd = sc.nextLine();
            Command command = cp.parse(cmd);

            switch (command) {
                case EXIT:
                    System.out.println("Application exiting...");
                    System.exit(0);
                    break;
            }

        }
    }

}
