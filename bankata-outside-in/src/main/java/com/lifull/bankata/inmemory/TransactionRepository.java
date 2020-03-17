package com.lifull.bankata.inmemory;

import com.lifull.bankata.infrastructure.TransactionInterface;
import com.lifull.bankata.repositories.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TransactionRepository implements TransactionInterface {
    private List<Transaction> transactions;

    public TransactionRepository() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public void save(Transaction transaction) {
        this.transactions.add(transaction);
    }

    @Override
    public String getStatement() {
        StringBuilder statement = new StringBuilder();
        int currentBalance = 0;
        for (Transaction transaction : transactions) {
            currentBalance = transaction.calculateBalance(currentBalance);
            statement.insert(0, transaction.toString() + currentBalance + ".00\n") ;
        }

        statement.insert(0, "date       || credit   || debit    || balance\n");

        return statement.toString();
    }

}
