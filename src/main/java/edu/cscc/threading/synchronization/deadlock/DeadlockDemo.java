package edu.cscc.threading.synchronization.deadlock;

public class DeadlockDemo {

    public static void main(String[] args) {
        Account account = new Account(1000);
        Account account2 = new Account(1000);

        new Thread(() -> {
            account.transfer(account2, 100);
        }).start();

        new Thread(() -> {
            account2.transfer(account, 100);
        }).start();
    }
}
