package services;

import database.ItemDB;
import database.TaxBlockDB;
import model.ItemModel;
import model.TaxBlock;
import model.TaxType;
import org.json.JSONObject;

public class ItemParser {

    private final JSONObject taxJsonObject;
    private ItemModel itemModel;

    public ItemParser(JSONObject jsonObject) {
        taxJsonObject = jsonObject;
    }

    public void ParseToItemModel() {
        String[] keys = JSONObject.getNames(taxJsonObject);
        for (String key : keys){
            JSONObject keyData = (JSONObject) taxJsonObject.get(key);
            String item = keyData.has("item") ?
                    keyData.getString("item") : "NA";
            int basePrice = keyData.has("basePrice") ?
                    keyData.getInt("basePrice") : 0;
            int discount = keyData.has("discount") ?
                    keyData.getInt("discount") : 0;
            itemModel = new ItemModel(item, basePrice, discount);
            ItemDB.addToItemDB(itemModel);
        }
    }

}
