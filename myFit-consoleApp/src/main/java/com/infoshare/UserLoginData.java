package com.infoshare;

import com.infoshare.Utils.UserDataBase;

import java.io.File;
import java.util.Objects;
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
        System.out.println("Type user name");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        while (!loginUserNameCheck(name)) {
            name = typoChecker("user name:");
        }
       if(!loginUserPasswordCheck(password)){
           System.out.println("Type password:");
           password = scanner.nextLine();
       }
        while(!loginUserPasswordCheck(password)){
            password = typoChecker("password");
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
        while (name.contains(" ") || name.equals("")) {
            System.out.println("name can't be empty, or contains spaces");
            name = scanner.nextLine();
        }
        while (UserDataBase.loginData.contains(new UserLoginData(name, password))) {
            System.out.println("User name already exists, type another");
            name = scanner.nextLine();
        }
        System.out.println("Type password:");
        password = scanner.nextLine();
        while (password.contains(" ") || password.equals("")) {
            System.out.println("password can't be empty, or contains spaces");
            password = scanner.nextLine();
        }
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
        File file = new File(Menu.RESOURCES_USER_DATA + name + ".json");
        return file.exists();
    }

    public String getName() {
        return name;
    }

    private String typoChecker(String showPhrase) {
        String phraseChecker = showPhrase;
        System.out.println("Wrong " + showPhrase);
        System.out.println("Would you like to try again or create a new account?");
        System.out.println("1. try again");
        System.out.println("2. create new account");
        int choice = Menu.choiceChecker(2);
        switch (choice) {
            case 1:
                System.out.println("Type " + showPhrase + ":");
                Scanner scanner = new Scanner(System.in);
                phraseChecker = scanner.nextLine();
                break;
            case 2:
                createAccount();
                if (showPhrase.equals("password")) {
                    phraseChecker = password;
                } else {
                    phraseChecker = name;
                }
                break;
        }
        return phraseChecker;
    }

    public void changeUserName() {
        String oldUserName = name;
        System.out.println("Type new user name");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        while (UserDataBase.loginData.contains(new UserLoginData(name, password))) {
            System.out.println("User name already exists, type another");
            name = scanner.nextLine();
        }
        File oldUserFile = new File(Menu.RESOURCES_USER_DATA + oldUserName + ".json");
        UserDataBase.loginData.remove(new UserLoginData(oldUserName, password));
        UserDataBase.loginData.add(new UserLoginData(name, password));
        File loginDataFile = new File("src/main/resources/loginData.json");
        if (loginDataFile.delete()) {
            UserDataBase.saveToFile();
        }
        if (oldUserFile.delete()) {
            System.out.println("All okay");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLoginData that = (UserLoginData) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
