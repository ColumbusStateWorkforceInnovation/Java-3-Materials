package edu.cscc.threading.synchronization.deadlock;

public class Account {

    private double balance;

    public Account(double startingBalance) {
        balance = startingBalance;
    }

    public synchronized double getBalance() { return balance; }

    public synchronized void transfer(Account account, double amount) {
        System.out.println("Waiting to get the balance.");
        if (account.getBalance() >= getBalance()) {
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting to debit.");
            account.debit(amount);
            this.balance += amount;
        }
    }

    //Other methods...

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
