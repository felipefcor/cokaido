import app.repositories.Deposit;
import app.repositories.Withdrawal;
import org.junit.Assert;
import org.junit.Test;

public class WithdrawalShould {
    @Test
    public void create_a_valid_withdrawal_transaction() {
        Withdrawal withdrawal = new Withdrawal(500, "14/01/2012");
        Assert.assertEquals("14/01/2012 ||          || 500.00   || ", withdrawal.toString());
    }

    @Test
    public void calculate_balance(){
        Withdrawal withdrawal = new Withdrawal(500, "14/01/2012");

        Assert.assertEquals(500, withdrawal.calculateBalance(1000));
    }

}
