package com.infoshare;

import com.infoshare.Utils.UserDataBase;

import java.io.File;
import java.util.Scanner;

public class UserLoginData {
    private String name;
    private String password;

     UserLoginData(){}

    UserLoginData(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void userLogin() {
        boolean bool = false;
        System.out.println("type user name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        if (!loginUserNameCheck(name)) {
            do {
                System.out.println("Wrong username");
                System.out.println("Would you like to try again or create a new account?");
                System.out.println("1. try again");
                System.out.println("2. create new account");
                int choice = Menu.choiceChecker(2);
                switch (choice) {
                    case 1:
                        name = scanner.nextLine();
                        break;
                    case 2:
                        bool = true;
                        createAccount();
                        break;
                }
            } while (!bool || !loginUserNameCheck(name));
        }
        if (!bool) {
            do {
                System.out.println("type password:");
                password = scanner.nextLine();
            } while (!loginUserPasswordCheck(password));
        }
    }

    private boolean loginUserNameCheck(String name) {
        for (int i = 0; i < UserDataBase.loginData.size(); i++) {
            if (UserDataBase.loginData.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean loginUserPasswordCheck(String password) {
        for (int i = 0; i < UserDataBase.loginData.size(); i++) {
            if (UserDataBase.loginData.get(i).password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void createAccount() {
        String retypedPassword;
        System.out.println("Type user name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Type password:");
        password = scanner.nextLine();
        System.out.println("Type password again:");
        retypedPassword = scanner.nextLine();
        while (!retypedPassword.equals(password)) {
            System.out.println("Wrong! Type password again");
            retypedPassword = scanner.nextLine();
        }
        UserDataBase.loginData.add(new UserLoginData(name, password));
        UserDataBase.saveToFile();
    }

    public boolean checkFileExist() {
        File file = new File(Menu.RESOURCES_USER_DATA + name);
        return file.exists();
    }

    public String getName() {
        return name;
    }

}
