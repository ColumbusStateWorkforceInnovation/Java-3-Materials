package edu.cscc.threading.synchronization.method;

public class Account {
    private double balance;

    public Account(double startingBalance) {
        balance = startingBalance;
    }

    public synchronized double getBalance() { return balance; }

    public synchronized void debit(double amount) {
        if (balance >= amount) {
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
        }
    }
}