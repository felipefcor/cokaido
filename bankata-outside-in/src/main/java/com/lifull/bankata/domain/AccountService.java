package com.lifull.bankata.domain;

import com.lifull.bankata.infrastructure.TransactionInterface;
import com.lifull.bankata.domain.transaction.Deposit;
import com.lifull.bankata.domain.transaction.Withdrawal;
import com.lifull.bankata.timeserver.TimeServer;

public class AccountService {

    private final TransactionInterface repository;
    private TimeServer timeServer;

    public AccountService(TransactionInterface repository, TimeServer timeServer) {
        this.repository = repository;
        this.timeServer = timeServer;
    }

    public void deposit(int amount) {
        repository.save(new Deposit(amount, timeServer.getDate()));
    }

    public void withdraw(int amount) {
        repository.save(new Withdrawal(amount, timeServer.getDate()));
    }

    public void printStatement() {
        repository.getStatement();
    }
}

