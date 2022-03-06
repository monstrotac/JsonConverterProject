package dim.uqac.jsonconverter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader{
    public JSONReader (){
    }
    //Read a JSON file and return an array
    public JSONArray GetJSONDataFromFile(String fileName){
        //Set the json parser
        JSONParser jsonParser = new JSONParser();
        //Set the return data
        JSONArray data = null;
        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            data = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

}