import app.Account;
import app.printable.Printable;
import app.repositories.Deposit;
import app.repositories.TransactionRepository;
import app.repositories.Withdrawal;
import app.timeserver.TimeServer;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*; /* Powered by Anna */

@ExtendWith(MockitoExtension.class)
public class AccountShould {
    @Mock
    private Printable printer;

    @Mock
    private TransactionRepository repository;

    @Mock
    private TimeServer timeServer;

    @InjectMocks
    private Account account;

    @Test
    public void send_deposit_to_repository() {
        MockitoAnnotations.initMocks(this);

        account.deposit(1000);

        verify(repository).save(new Deposit(1000, timeServer.getDate()));
    }

    @Test
    public void send_withdrawal_to_repository() {

        MockitoAnnotations.initMocks(this);

        account.withdraw(500);

        verify(repository).save(new Withdrawal(500, timeServer.getDate()));
    }

    @Test
    public void get_statement_from_repository_and_send_it_to_printer() {

        MockitoAnnotations.initMocks(this);
        account = new Account(repository, printer, timeServer);

        when(repository.getStatement()).thenReturn("Amount");
        account.printStatement();

        verify(printer).print("Amount");
    }
}
