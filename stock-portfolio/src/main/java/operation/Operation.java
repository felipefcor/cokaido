package operation;

import java.util.Objects;

public abstract class Operation {
    final int shareAmount;
    final String companyName;
    final double price;
    private final String date;

    protected Operation(int shareAmount, String companyName, double price, String date) {
        this.shareAmount = shareAmount;
        this.companyName = companyName;
        this.price = price;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return shareAmount == operation.shareAmount &&
                Double.compare(operation.price, price) == 0 &&
                Objects.equals(companyName, operation.companyName) &&
                Objects.equals(date, operation.date);
    }
}
