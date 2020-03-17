package com.lifull.bankata.infrastructure;

public interface TransactionInterface {
    void save(com.lifull.bankata.repositories.Transaction transaction);

    String getStatement();
}
