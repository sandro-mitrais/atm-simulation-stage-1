package org.learning.atmsimulation.main;

import org.learning.atmsimulation.model.Account;
import org.learning.atmsimulation.service.AccountService;

import java.util.Scanner;

public class Main {

    static final String BALANCE_INFORMATION = "Your current balance is ";

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        Account accountSandro = new Account("Sandro", 0.0);
        Account accountSihaloho = new Account("Sihaloho", 0.0);
        int command;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("""
                    ========================================================
                    Welcome to ATM Simulation.....
                    0. Exit
                    1. Deposit Money
                    2. Withdraw Money
                    3. Transfer Funds
                    ========================================================
                    """);
            command = scanner.nextInt();

            if (command == 0) {
                System.out.print("Thank you for using ATM Simulation.");
            }

            if (command == 1) {
                System.out.print("How much money would you like to deposit?");
                Double money = scanner.nextDouble();
                accountSandro.deposit(money);
                System.out.println("Success deposit money " + money);
                System.out.println(BALANCE_INFORMATION + accountSandro.getBalance());
            }
            if (command == 2) {
                System.out.println(BALANCE_INFORMATION + accountSandro.getBalance());
                System.out.print("How much money would you like to withdraw?");
                Double money = scanner.nextDouble();
                accountSandro.withdraw(money);
                System.out.println("Success withdraw money " + money);
                System.out.println(BALANCE_INFORMATION + accountSandro.getBalance());
            }
            if (command == 3) {
                System.out.println(BALANCE_INFORMATION + accountSandro.getBalance());
                System.out.println("How much funds would you like to transfer?");
                Double amount = scanner.nextDouble();
                accountService.transfer(accountSandro, accountSihaloho, amount);
            }

        } while (command != 0);

    }
}
