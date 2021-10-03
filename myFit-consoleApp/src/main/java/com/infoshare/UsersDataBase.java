package com.infoshare;

import java.util.Scanner;

public class UsersDataBase {
    public void logInUser() {
        String name;
        String password;
        System.out.println("Hello. You can Log In into a system.");
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Enter your password:");
        scanner = new Scanner(System.in);
        password = scanner.nextLine();

        System.out.println("User " + name + " is logged in.");
    }

    private boolean isInUsersDatabase(String name, String password) {
        /*
         TODO
         Logika sprawdzająca, czy użytkownik jest w bazie danych
        */
        return true;
    }

    public void addUser() {
        String name;
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name for new user:");
        name = scanner.nextLine();
        System.out.println("Enter password for new user:");
        scanner = new Scanner(System.in);
        password = scanner.nextLine();

        System.out.println("New user: " + name + " added.");
    }


}
