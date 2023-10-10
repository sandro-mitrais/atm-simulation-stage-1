package org.learning.atmsimulation.service;

import org.learning.atmsimulation.model.Account;

public class AccountService {

    static class BalanceException extends Exception {
        public BalanceException() {
            super("Balance is insufficient");
        }
    }

    public void addBalance(Account a, Double d) {
        a.setBalance(a.getBalance() + d);
    }

    public void reduceBalance(Account a, Double d) throws BalanceException {
        double temp = a.getBalance() - d;

        if (temp > 0) {
            a.setBalance(a.getBalance() - d);
        } else {
            throw new BalanceException();
        }
    }

    public void transfer(Account sender, Account receiver, Double funds) {
        try {
            //reduce balance from sender
            reduceBalance(sender, funds);
            //add balance to receiver
            addBalance(receiver, funds);
            System.out.println("Transfer " + funds + " from: " + sender.getName() + " to: " + receiver.getName()
                    + " is succeed.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
