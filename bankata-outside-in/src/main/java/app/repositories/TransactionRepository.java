package app.repositories;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private List<Transaction> transactions;

    public TransactionRepository() {
        this.transactions = new ArrayList<>();
    }

    public void save(Transaction transaction) {
        this.transactions.add(transaction);
    }

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
