package edu.cscc.threading.raceconditions;

import java.util.stream.IntStream;

public class AccountWithdrawer extends Thread {

    private Account account;

    public AccountWithdrawer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        IntStream intStream = IntStream.range(0, 100);
        intStream.forEach(value -> {
            displayCurrentBalance();
            double amount = 10;
            if (account.getBalance() >= amount) {
                displayWithdrawingMesssage(amount);
                account.debit(amount);
                displayCompletedWithdrawalMessage();
            }
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
