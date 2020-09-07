package edu.cscc.threading.synchronization;

import edu.cscc.threading.raceconditions.Account;

public class SynchronizedAccount implements Account {
    private double balance;

    public SynchronizedAccount(double startingBalance) {
        balance = startingBalance;
    }

    public synchronized double getBalance() { return balance; }

    public synchronized void debit(double amount) {
        balance -= amount;
    }
}