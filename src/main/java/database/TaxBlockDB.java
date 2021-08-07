package database;

import model.TaxBlock;

import java.util.ArrayList;

public class TaxBlockDB {

    private static ArrayList<TaxBlock> taxBlockList= new ArrayList();

    public static ArrayList<TaxBlock> getTaxBlockList() {
        return taxBlockList;
    }

    public static void addToTaxBlockDB(TaxBlock taxBlock){
        taxBlockList.add(taxBlock);
    }

}
