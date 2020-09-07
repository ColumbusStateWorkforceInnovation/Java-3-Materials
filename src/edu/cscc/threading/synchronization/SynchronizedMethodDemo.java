package edu.cscc.threading.synchronization;

import edu.cscc.threading.raceconditions.AccountWithdrawer;

public class SynchronizedMethodDemo {

    public static void main(String[] args) {
        SynchronizedAccount synchronizedAccount = new SynchronizedAccount(1000);
        System.out.println("Starting balance is: " + synchronizedAccount.getBalance());

        AccountWithdrawer accountWithdrawer = new AccountWithdrawer(synchronizedAccount);
        AccountWithdrawer accountWithdrawer2 = new AccountWithdrawer(synchronizedAccount);

        accountWithdrawer.start();
        accountWithdrawer2.start();
    }
}
