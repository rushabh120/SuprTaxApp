package services;

import database.TaxBlockDB;
import model.TaxBlock;
import model.TaxType;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;

public class TaxBlockParser {

    private final JSONObject taxJsonObject;
    private TaxBlock taxBlock;

    public TaxBlockParser(JSONObject jsonObject) {
        taxJsonObject = jsonObject;
    }

    public void ParseToTaxBlock() {
        String[] keys = JSONObject.getNames(taxJsonObject);
        for (String key : keys){
            JSONObject keyData = (JSONObject) taxJsonObject.get(key);
            int minPrice = keyData.has("minPrice") ?
                    keyData.getInt("minPrice") : 0;
            int maxPrice = keyData.has("maxPrice") ?
                    keyData.getInt("maxPrice") : Integer.MAX_VALUE;
            int tax = keyData.has("tax") ?
                    keyData.getInt("tax") : 0;
            TaxType taxType = keyData.has("type") ?
                    TaxType.valueOf(keyData.getString("type").toUpperCase(Locale.ROOT)) : TaxType.FIXED;
            taxBlock = new TaxBlock(minPrice, maxPrice, tax, taxType);
            TaxBlockDB.addToTaxBlockDB(taxBlock);
        }
    }

}
