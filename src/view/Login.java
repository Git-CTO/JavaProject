package view;


import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    String userName;
    String password;
    public void login(){
        System.out.println("hello, welcome to EHRP! " +
                "\n please enter username and password:");
        System.out.println("username: ");
       userName = scanner.nextLine();
        System.out.println("password: ");
        password = scanner.nextLine();

        //todo: authentication with the data in json

    }

    public boolean authenticateUser(){
        return false;
    }
}
