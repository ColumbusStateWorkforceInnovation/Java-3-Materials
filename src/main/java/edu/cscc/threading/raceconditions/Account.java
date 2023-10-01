package edu.cscc.threading.raceconditions;

public class Account {
    private double balance;

    public Account(double startingBalance) {
        balance = startingBalance;
    }

    public double getBalance() { return balance; }

    public void debit(double amount) {
        if (balance >= amount) {
            try {
                // Sleeping here to make it more likely to cause a
                // race condition.
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
        }
    }
}