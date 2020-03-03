import app.repositories.Deposit;
import org.junit.Assert;
import org.junit.Test;

public class DepositShould {
    @Test
    public void create_a_valid_deposit_transaction() {
        Deposit deposit = new Deposit(1000, "10/01/2012");

        Assert.assertEquals("10/01/2012 || 1000.00  ||          || ", deposit.toString());
    }

    @Test
    public void calculate_balance(){
        Deposit deposit = new Deposit(1000, "10/01/2012");

        Assert.assertEquals(1000, deposit.calculateBalance(0));
    }

}
