package com.lifull.bankata.infrastructure;

public interface TransactionInterface {
    void save(com.lifull.bankata.domain.transaction.Transaction transaction);

    String getStatement();
}
