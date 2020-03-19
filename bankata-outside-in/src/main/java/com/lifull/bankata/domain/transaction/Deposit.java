package com.lifull.bankata.domain.transaction;

public class Deposit extends Transaction {

    public Deposit(int amount, String date) {
        super(amount, date);
    }

    @Override
    public int calculateBalance(int currentBalance) {
        return currentBalance + this.amount;
    }

    @Override
    public String toString() {
        return this.date + " || " + this.amount + ".00  ||          || ";
    }
}