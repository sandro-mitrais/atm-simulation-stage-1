package org.learning.atmsimulation.model;

public class Account {

    static        int    index = 1;
    private final int    id;
    private final String name;
    private       Double balance;

    public Account(String name, Double balance) {
        this.id = index;
        this.name = name;
        this.balance = balance;
        index++;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deposit(Double money) {
        this.setBalance(this.getBalance()+money);
    }

    public void withdraw(Double money) {
        this.setBalance(this.getBalance()-money);
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name='" + name + '\'' + ", balance=" + balance + '}';
    }
}
