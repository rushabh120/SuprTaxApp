package model;

public class TaxBlock {

    private final int minPrice;
    private final int maxPrice;
    private final int tax;

    private final TaxType taxType;

    public TaxBlock(int minPrice, int maxPrice, int tax, TaxType taxType) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.tax = tax;
        this.taxType = taxType;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getTax() {
        return tax;
    }

    public TaxType getTaxType() {
        return taxType;
    }
}

