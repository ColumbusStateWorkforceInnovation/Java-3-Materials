package edu.cscc.threading;

public class Account {
    private double balance;

    public Account(double startingBalance) {
        balance = startingBalance;
    }

    public double getBalance() { return balance; }

    public void debit(double amount) {
        balance -= amount;
    }
}