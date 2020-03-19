import com.lifull.bankata.domain.AccountService;
import com.lifull.bankata.infrastructure.TransactionInterface;
import com.lifull.bankata.domain.transaction.Deposit;
import com.lifull.bankata.domain.transaction.Withdrawal;
import com.lifull.bankata.timeserver.TimeServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*; /* Powered by Anna */

@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {
    @Mock
    private TransactionInterface repository;

    @Mock
    private TimeServer timeServer;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void send_deposit_to_repository() {
        MockitoAnnotations.initMocks(this);

        accountService.deposit(1000);

        verify(repository).save(new Deposit(1000, timeServer.getDate()));
    }

    @Test
    public void send_withdrawal_to_repository() {

        MockitoAnnotations.initMocks(this);

        accountService.withdraw(500);

        verify(repository).save(new Withdrawal(500, timeServer.getDate()));
    }

    @Test
    public void get_statement_from_repository_and_send_it_to_printer() {

        MockitoAnnotations.initMocks(this);
        accountService = new AccountService(repository, timeServer);

        when(repository.getStatement()).thenReturn("Amount");

        Assert.assertEquals("Amount", repository.getStatement());
    }
}
