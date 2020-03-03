package repository;

import app.AssetReport;
import app.PortfolioReport;
import operation.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationRepository {
    private List<Operation> operations = new ArrayList<>();

    public void save(Operation operation) {
        this.operations.add(operation);
    }

    public PortfolioReport getPortfolioReport() {
        PortfolioReport portfolioReport = new PortfolioReport();
        portfolioReport.assetsList.add(new AssetReport("Old School Waterfall Software LTD", "1000", "5,75", "2,875.00", "sold 500 on 11/12/2018"));
        return portfolioReport;
    }
}
