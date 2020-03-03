import app.AssetReport;
import app.Portfolio;
import app.PortfolioReport;
import formatter.Formatter;
import operation.Buy;
import operation.Sell;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import printable.Printable;
import repository.OperationRepository;
import timeserver.TimeServer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PortfolioShould {

    @Mock
    private Printable printer;

    @Mock
    private OperationRepository repository;

    @Mock
    private TimeServer timeServer;

    @Mock
    private Formatter formatter;

    @Test
    public void send_buy_operation_to_repository() {

        MockitoAnnotations.initMocks(this);
        Portfolio portfolio = new Portfolio(printer, repository, timeServer, formatter);

        portfolio.buy(1000, "Old School Waterfall Software LTD", 5.75);

        verify(repository).save(new Buy(1000, "Old School Waterfall Software LTD", 5.75, timeServer.getDate()));
    }

    @Test
    public void send_sell_operation_to_repository() {

        MockitoAnnotations.initMocks(this);
        Portfolio portfolio = new Portfolio(printer, repository, timeServer, formatter);

        portfolio.sell(500, "Old School Waterfall Software LTD", 5.75);

        verify(repository).save(new Sell(500, "Old School Waterfall Software LTD", 5.75, timeServer.getDate()));
    }

    @Test
    public void print_operations() {

        MockitoAnnotations.initMocks(this);
        Portfolio portfolio = new Portfolio(printer, repository, timeServer, formatter);
        PortfolioReport portfolioReport = new PortfolioReport();

        when(repository.getPortfolioReport()).thenReturn(portfolioReport);
        when(formatter.create(portfolioReport)).thenReturn(" foo ");
        portfolio.print();

        verify(printer).print(" foo ");
    }
}
