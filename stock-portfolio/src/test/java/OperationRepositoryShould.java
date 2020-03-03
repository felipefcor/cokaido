import app.AssetReport;
import app.PortfolioReport;
import operation.Buy;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.OperationRepository;
import timeserver.TimeServer;

public class OperationRepositoryShould {

    @Mock
    TimeServer timeServer;



    @Test
    public void save_operation_in_repository(){

        MockitoAnnotations.initMocks(this);
        OperationRepository operationRepository = new OperationRepository();
        PortfolioReport expected = new PortfolioReport();
        expected.assetsList.add(new AssetReport("Old School Waterfall Software LTD", "1000", "5,75", "2,875.00","sold 500 on 11/12/2018"));

        operationRepository.save(new Buy(1000, "Old School Waterfall Software LTD", 5.75, timeServer.getDate()));

        Assert.assertEquals(expected, operationRepository.getPortfolioReport());
    }
}
