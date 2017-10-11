package be.ua.bank;

import java.util.Scanner;

public class UserInterface {
    private Scanner input;

    public UserInterface() {
        input = new Scanner(System.in);
        System.out.println("Welcome to the bank");
        selectOption();
    }

    public void selectOption() {
        System.out.println("Choose an option:\n\t 1. View balance");
        System.out.println("\t 2. Desposit money");
        System.out.println("\t 3. Withdraw money");

       int selection =  input.nextInt();
    }
}
