package edu.cscc.threading.synchronization;

import edu.cscc.threading.raceconditions.AccountImpl;

public class SynchronizedBlockDemo {

    public static void main(String[] args) {
        AccountImpl account = new AccountImpl(1000);
        System.out.println("Starting balance is: " + account.getBalance());

        SynchronizedAccountWithdrawer accountWithdrawer = new SynchronizedAccountWithdrawer(account);
        SynchronizedAccountWithdrawer accountWithdrawer2 = new SynchronizedAccountWithdrawer(account);

        accountWithdrawer.start();
        accountWithdrawer2.start();
    }
}
