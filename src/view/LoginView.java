package view;

import controller.Controller;

import java.util.Scanner;

public class LoginView {
    private static LoginView loginView = null;
    private Scanner scanner = new Scanner(System.in);
    private String userName;
    private String password;

    private LoginView(){
    }

    public static LoginView createLoginViewInstance(){
        if (loginView == null){
            loginView = new LoginView();
        }
        return loginView;
    }

     String loginAuthenticateUser() {
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
