package edu.cscc.threading.raceconditions;

public interface Account {
    double getBalance();

    void debit(double amount);
}
