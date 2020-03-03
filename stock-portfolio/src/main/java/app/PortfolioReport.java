package app;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PortfolioReport {

    public List<AssetReport> assetsList;

    public PortfolioReport() {
        assetsList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortfolioReport that = (PortfolioReport) o;
        return Objects.equals(assetsList, that.assetsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetsList);
    }
}
