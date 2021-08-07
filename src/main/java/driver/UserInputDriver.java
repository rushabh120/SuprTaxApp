package driver;

import org.json.JSONObject;
import services.FinalPriceCalculator;
import services.ItemParser;
import services.TaxBlockParser;

import java.nio.file.Files;
import java.nio.file.Paths;

public class UserInputDriver {

    public static void main(String[] args) {

        String taxFilePath = args[0]; //tax
        String itemFilePath = args[1]; //item
        try {
            String jsonText = new String(Files.readAllBytes(Paths.get(taxFilePath)));
            JSONObject jsonObject = new JSONObject(jsonText);
            
            TaxBlockParser taxBlockParser = new TaxBlockParser(jsonObject);
            taxBlockParser.ParseToTaxBlock();

            jsonText = new String(Files.readAllBytes(Paths.get(itemFilePath)));
            jsonObject = new JSONObject(jsonText);
            
            ItemParser itemParser = new ItemParser(jsonObject);
            itemParser.ParseToItemModel();

            FinalPriceCalculator.calculateFinalPrice();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }


    }

}
