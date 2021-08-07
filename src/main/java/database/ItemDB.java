package database;

import model.ItemModel;

import java.util.ArrayList;

public class ItemDB {

    private static ArrayList<ItemModel> itemModelList = new ArrayList<>();

    public static void addToItemDB(ItemModel itemModel) {
        itemModelList.add(itemModel);
    }

    public static ArrayList<ItemModel> getItemModelList() {
        return itemModelList;
    }

}
