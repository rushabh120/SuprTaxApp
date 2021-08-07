package services;

import database.ItemDB;
import database.TaxBlockDB;
import model.ItemModel;
import model.TaxBlock;

public class FinalPriceCalculator {

    public static void calculateFinalPrice(){
        for (ItemModel itemModel : ItemDB.getItemModelList()) {
            itemModel.setFinalPrice(
                    itemModel.getBasePrice() +
                    calculateTax(itemModel) -
                    calculateDiscount(itemModel));
            System.out.println(itemModel.toString()); 
        }
    }

    private static int calculateDiscount(ItemModel itemModel) {
        return itemModel.getDiscount() * itemModel.getBasePrice() / 100;
    }

    private static int calculateTax(ItemModel itemModel) {
        int applicableTax = 0;
        for (TaxBlock taxBlock : TaxBlockDB.getTaxBlockList()) {
            if (taxBlock.getMinPrice() < itemModel.getBasePrice() &&
                    taxBlock.getMaxPrice() >= itemModel.getBasePrice()) {
                applicableTax += getApplicableTaxFromTaxBlock(taxBlock, itemModel);
            }
        }
        return applicableTax;
    }

    private static int getApplicableTaxFromTaxBlock(TaxBlock applicableBlock, ItemModel itemModel) {
        int applicableTaxAmount = 0;
        switch (applicableBlock.getTaxType()) {
            case FIXED:
                applicableTaxAmount = applicableBlock.getTax();
                break;
            case PERCENTAGE:
                applicableTaxAmount = applicableBlock.getTax() *
                        itemModel.getBasePrice() / 100;
                break;
        }
        return  applicableTaxAmount;
    }

}
