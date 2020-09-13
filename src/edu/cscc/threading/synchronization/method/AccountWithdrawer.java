package edu.cscc.threading.synchronization.method;

import java.util.stream.IntStream;

public class AccountWithdrawer extends Thread {

    private Account account;

    public AccountWithdrawer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        IntStream intStream = IntStream.range(0, 60);
        intStream.forEach(value -> {
            displayCurrentBalance();
            double amount = 100;
                displayWithdrawingMesssage(amount);
                account.debit(amount);
            if (account.getBalance() < 0) {
                displayAccountOverdrawnMessage();
            }
        });
    }

    //Helper methods...

    private void displayAccountOverdrawnMessage() {
        System.out.println("Account is overdrawn!");
    }

    private void displayCompletedWithdrawalMessage() {
        System.out.println(
                Thread.currentThread().getName()
                        + " completed withdrawal.");
    }

    private void displayWithdrawingMesssage(double amount) {
        System.out.println(
                Thread.currentThread().getName()
                        + " withdrawing "
                        + amount
                        + "...");
    }

    private void displayCurrentBalance() {
        System.out.println(
                Thread.currentThread().getName()
                        + ", "
                        + "Current balance is: "
                        + account.getBalance());
    }
}
