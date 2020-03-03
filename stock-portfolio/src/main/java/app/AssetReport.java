package app;

import java.util.Objects;

public class AssetReport {
    private final String companyName;
    private final String shares;
    private final String currentPrice;
    private final String currentValue;
    private final String lastOperation;

    public AssetReport(String companyName, String shares, String currentPrice, String currentValue, String lastOperation
    ) {
        this.companyName = companyName;
        this.shares = shares;
        this.currentPrice = currentPrice;
        this.currentValue = currentValue;
        this.lastOperation = lastOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetReport that = (AssetReport) o;
        return Objects.equals(companyName, that.companyName) &&
                Objects.equals(shares, that.shares) &&
                Objects.equals(currentPrice, that.currentPrice) &&
                Objects.equals(currentValue, that.currentValue) &&
                Objects.equals(lastOperation, that.lastOperation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, shares, currentPrice, currentValue, lastOperation);
    }
}
