package org.learning.atmsimulation.main;

import org.learning.atmsimulation.model.Account;
import org.learning.atmsimulation.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        AccountService accountService = new AccountService();
        int command;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                    ========================================================
                    Welcome to ATM Simulation.....
                    0. Exit
                    1. Create new account
                    2. Transfer balance
                    3. PrintAll
                    ========================================================
                    """);
            command = scanner.nextInt();

            if (command == 0) {
                System.out.print("Thank you for using ATM Simulation.");
            }

            if (command == 1) {
                System.out.print("What is your name?");
                String name = scanner.next();
                System.out.print("What is your balance?");
                Double balance = scanner.nextDouble();
                accounts.add(new Account(name, balance));
                System.out.println("Success create new account");
            }
            if (command == 2) {
                if (accounts.size() < 2) {
                    System.out.println("Not enough account is found.");
                } else {
                    System.out.print("----Login----\nPlease insert sender ID:");
                    int idSender = scanner.nextInt();
                    System.out.print("Please insert receiver ID:");
                    int idReceiver = scanner.nextInt();
                    System.out.println("How much the transfer?");
                    Account sender = accounts.stream().filter(account -> account.getId() == idSender).findFirst()
                            .orElse(null);
                    Account receiver = accounts.stream().filter(account -> account.getId() == idReceiver).findFirst()
                            .orElse(null);
                    Double amount = scanner.nextDouble();
                    // do the transfer
                    accountService.transfer(sender, receiver, amount);
                }
            }
            if (command == 3) {
                if (!accounts.isEmpty()) {
                    System.out.println("We got " + accounts.size() + " account");
                    for (Account a : accounts) {
                        System.out.println(a);
                    }
                } else {
                    System.out.println("No account registered.");
                }
            }

        } while (command != 0);

    }
}
