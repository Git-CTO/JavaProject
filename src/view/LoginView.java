package view;

import controller.Controller;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    String userName;
    String password;

    public String loginAuthenticateUser() {
        do {
            System.out.println("please enter username and password:");
            System.out.println("username: ");
            userName = scanner.nextLine();
            System.out.println("password: ");
            password = scanner.nextLine();
        } while (!authenticateUser(userName, password));

        if(userName.equals("root")) {
            return "root";
        }else {
            return userName.split("@")[0];
        }
    }

    private boolean authenticateUser(String userName, String password) {
        return Controller.authenticateUser(userName, password);
    }
}
