package acceptance;

import app.Portfolio;
import formatter.Formatter;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import printable.Printable;
import repository.OperationRepository;
import timeserver.TimeServer;


import static org.mockito.Mockito.*;

        /*

        Given I bought 1000 shares of “Old School Waterfall Software LTD” on 14/02/1990
        and I bought 400 shares of “Crafter Masters Limited” on 09/06/2016
        and I bought 700 shares of “XP Practitioners Incorporated” on 10/12/2018
        and I sold 500 shares of “Old School Waterfall Software LTD” on 11/12/2018
        and the current share value of “Old School Waterfall Software LTD” is $5.75
        and the current share value of “Crafter Masters Limited” is $17.25
        and the current share value of “XP Practitioners Incorporated” is $25.55

        company | shares | current price | current value | last operation
        Old School Waterfall Software LTD | 500 | $5.75 | $2,875.00 | sold 500 on 11/12/2018
        Crafter Masters Limited | 400 | $17.25 | $6,900.00 | bought 400 on 09/06/2016
        XP Practitioners Incorporated | 700 | $25.55 | $17,885.00 | bought 700 on 10/12/2018
        */

@ExtendWith(MockitoExtension.class)

public class PrintPortfolioFeature {

    @Mock
    private Printable printer;

    @Mock
    private TimeServer timeServer;

    @Mock
    private Formatter formatter;

    @Test
    public void print_the_portfolio_in_the_correct_format(){
        MockitoAnnotations.initMocks(this);
        OperationRepository repository = new OperationRepository();
        Portfolio portfolio = new Portfolio(printer, repository, timeServer, formatter);

        when(timeServer.getDate()).thenReturn("14/02/1990","11/12/2018", "09/06/2016", "10/12/2018");

        portfolio.buy(1000, "Old School Waterfall Software LTD", 5.75);
        portfolio.buy(400, "Crafter Masters Limited", 17.25);
        portfolio.buy(700, "XP Practitioners Incorporated", 25.55);
        portfolio.sell(500, "Old School Waterfall Software LTD", 5.75);
        portfolio.print();


        verify(printer).print("company | shares | current price | current value | last operation\n" +
                "Old School Waterfall Software LTD | 500 | $5.75 | $2,875.00 | sold 500 on 11/12/2018\n" +
                "Crafter Masters Limited | 400 | $17.25 | $6,900.00 | bought 400 on 09/06/2016\n" +
                "XP Practitioners Incorporated | 700 | $25.55 | $17,885.00 | bought 700 on 10/12/2018\n");
    }
}

