package com.kleim;

import java.util.Scanner;

public class OperationsConsoleListener {

    private final Scanner scanner;

    public OperationsConsoleListener(Scanner scanner) {
        this.scanner = scanner;
    }

    public void consoleListener() {
        System.out.println("Type operations");
        while (true) {
            System.out.println("Type next operations");
            String nextOperation = scanner.nextLine();
            if (nextOperation.equalsIgnoreCase("USER_CREATE")) {
                System.out.println("User created.");
            } else if (nextOperation.equalsIgnoreCase("ACCOUNT_CREATE")) {
                System.out.println("Account created.");
            } else {
                System.out.println("Not found operation.");
            }
        }
    }
}
