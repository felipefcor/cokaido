package acceptance;

import com.lifull.bankata.domain.AccountService;
import com.lifull.bankata.infrastructure.TransactionInterface;
import com.lifull.bankata.timeserver.TimeServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.lifull.bankata.infrastructure.inmemory.TransactionRepositoryInMemory;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/*Given a client makes a deposit of 1000 on 10-01-2012
And a deposit of 2000 on 13-01-2012
And a withdrawal of 500 on 14-01-2012
When she prints her bank statement
Then she would see:

date       || credit   || debit    || balance
14/01/2012 ||          || 500.00   || 2500.00
13/01/2012 || 2000.00  ||          || 3000.00
10/01/2012 || 1000.00  ||          || 1000.00

*/

@ExtendWith(MockitoExtension.class)
public class PrintStatementFeature {

    @Mock
    private TimeServer timeServer;

    @Test
    public void print_the_bank_Statement_correctly() {
        MockitoAnnotations.initMocks(this);
        TransactionInterface repository = new TransactionRepositoryInMemory();
        AccountService accountService = new AccountService(repository,  timeServer);
        when(timeServer.getDate()).thenReturn("10/01/2012","13/01/2012","14/01/2012");
        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);

        Assert.assertEquals("date       || credit   || debit    || balance\n" +
                "14/01/2012 ||          || 500.00   || 2500.00\n" +
                "13/01/2012 || 2000.00  ||          || 3000.00\n" +
                "10/01/2012 || 1000.00  ||          || 1000.00\n", repository.getStatement());
    }
}
