package model;

public class ItemModel {

    private final String itemName;

    private final int basePrice;
    private final int discount;
    private int finalPrice;


    public ItemModel(String itemName, int basePrice, int discount) {
        this.itemName = itemName;
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getDiscount() {
        return discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "itemName='" + itemName + '\'' +
                ", basePrice=" + basePrice +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
