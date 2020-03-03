package app;

import app.printable.Printable;
import app.repositories.Deposit;
import app.repositories.TransactionRepository;
import app.repositories.Withdrawal;
import app.timeserver.TimeServer;

public class Account {

    private final TransactionRepository repository;
    private final Printable printer;
    private TimeServer timeServer;

    public Account(TransactionRepository repository, Printable printer, TimeServer timeServer) {
        this.repository = repository;
        this.printer = printer;
        this.timeServer = timeServer;
    }

    public void deposit(int amount) {
        repository.save(new Deposit(amount, timeServer.getDate()));
    }

    public void withdraw(int amount) {
        repository.save(new Withdrawal(amount, timeServer.getDate()));
    }

    public void printStatement() {
        printer.print(repository.getStatement());
    }
}

