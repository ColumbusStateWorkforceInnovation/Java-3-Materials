package edu.cscc.threading.raceconditions;

public class RaceConditionDemo {

    public static void main(String[] args) {
        Account account = new AccountImpl(1000);
        System.out.println("Starting balance is: " + account.getBalance());

        AccountWithdrawer accountWithdrawer = new AccountWithdrawer(account);
        AccountWithdrawer accountWithdrawer2 = new AccountWithdrawer(account);

        accountWithdrawer.start();
        accountWithdrawer2.start();
    }
}
