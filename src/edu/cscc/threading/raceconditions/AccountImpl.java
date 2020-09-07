package edu.cscc.threading.raceconditions;

public class AccountImpl implements Account {
    private double balance;

    public AccountImpl(double startingBalance) {
        balance = startingBalance;
    }

    @Override
    public double getBalance() { return balance; }

    @Override
    public void debit(double amount) {
        balance -= amount;
    }
}