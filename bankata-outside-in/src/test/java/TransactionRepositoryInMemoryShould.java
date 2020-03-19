
import com.lifull.bankata.infrastructure.inmemory.TransactionRepositoryInMemory;
import com.lifull.bankata.domain.transaction.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionRepositoryInMemoryShould {
    @Mock
    private Transaction transaction;

    @Mock
    private Transaction newTransaction;

    @Test
    public void return_empty_statement() {
        TransactionRepositoryInMemory transactionRepositoryInMemory = new TransactionRepositoryInMemory();

        Assert.assertEquals("date       || credit   || debit    || balance\n", transactionRepositoryInMemory.getStatement());
    }

    @Test
    public void return_statement_with_a_deposit_of_1000() {
        MockitoAnnotations.initMocks(this);
        TransactionRepositoryInMemory transactionRepositoryInMemory = new TransactionRepositoryInMemory();

        when(transaction.toString()).thenReturn("10/01/2012 || 1000.00  ||          || ");
        when(transaction.calculateBalance(0)).thenReturn(1000);
        transactionRepositoryInMemory.save(transaction);

        Assert.assertEquals("date       || credit   || debit    || balance\n10/01/2012 || 1000.00  ||          || 1000.00\n", transactionRepositoryInMemory.getStatement());
    }
    @Test
    public void sort_transactions_by_date() {
        MockitoAnnotations.initMocks(this);
        TransactionRepositoryInMemory transactionRepositoryInMemory = new TransactionRepositoryInMemory();

        when(transaction.toString()).thenReturn("10/01/2012 || 1000.00  ||          || ");
        when(newTransaction.toString()).thenReturn("13/01/2012 || 2000.00  ||          || ");

        when(transaction.calculateBalance(0)).thenReturn(1000);
        when(newTransaction.calculateBalance(1000)).thenReturn(3000);

        transactionRepositoryInMemory.save(transaction);
        transactionRepositoryInMemory.save(newTransaction);

        Assert.assertEquals("date       || credit   || debit    || balance\n13/01/2012 || 2000.00  ||          || 3000.00\n10/01/2012 || 1000.00  ||          || 1000.00\n", transactionRepositoryInMemory.getStatement());
    }
}
