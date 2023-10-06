package org.learning.atmsimulation.model;

public class Account {

    static        int    index = 1;
    private final int    id;
    private       String name;
    private       Double balance;

    public Account(String name, Double balance) {
        this.id = index;
        this.name = name;
        this.balance = balance;
        index++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name='" + name + '\'' + ", balance=" + balance + '}';
    }
}
