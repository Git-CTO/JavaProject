package view;

import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    String userName;
    String password;

    public void loginAuthenticateUser() {
        do {
            System.out.println("please enter username and password:");
            System.out.println("username: ");
            userName = scanner.nextLine();
            System.out.println("password: ");
            password = scanner.nextLine();
        } while (!authenticateUser());

        //todo: authentication with the data in json

    }

    private boolean authenticateUser() {
        return true;
    }
}
