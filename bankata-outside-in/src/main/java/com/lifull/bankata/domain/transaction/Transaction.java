package com.lifull.bankata.domain.transaction;

import java.util.Objects;

public abstract class Transaction {
    protected int amount;
    protected String date;

    public Transaction(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public abstract int calculateBalance(int currentBalance);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                Objects.equals(date, that.date);
    }

}
