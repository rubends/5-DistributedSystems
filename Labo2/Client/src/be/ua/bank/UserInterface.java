package be.ua.bank;

import java.util.Scanner;

public class UserInterface {
    private Scanner input;
    private Bank bank;

    public UserInterface() {
        input = new Scanner(System.in);
        System.out.println("Welcome to the bank");
        setup();
        startUI();
    }

    private void setup() {
            // Eventueel vragen aan gebruiker
            RMIConnector connector =new  RMIConnector("localhost");
            bank = connector.getBank();
    }

    public void startUI() {
        while(true) {
            System.out.println("Choose an option:\n\t 1. View balance");
            System.out.println("\t 2. Desposit money");
            System.out.println("\t 3. Withdraw money");
            System.out.println("\t 4. Exit bank");
            System.out.print("> ");

            int selection = input.nextInt();
            switch (selection) {
                case 1:
                    getBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    private void  getBalance() {
       float balance = bank.getBalance();
       System.out.println("Current balance: "+balance);
    }

    private void deposit() {
        System.out.print("Please enter amount to deposit: ");
        bank.deposit(input.nextFloat());
    }

    private void withdraw() {
        System.out.print("Please enter amount to withdraw: ");
        float amount = input.nextFloat();
        if(bank.withdraw(amount)) {
            System.out.println("Withdrawal succeeded");
        }
        else {
            System.out.println("Withdrawal failed. Balance too low");
        }
    }
}
