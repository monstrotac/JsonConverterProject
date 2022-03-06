package dim.uqac.jsonconverter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader{

    public JSONReader (){

    }

    //Read a JSON file and return an array
    private JSONObject getJSONDataFromFile(String fileName){
        //Set the json parser
        JSONParser jsonParser = new JSONParser();
        //Set the return data
        JSONObject data = null;

        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            data = (JSONObject) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Presentation generatePresentation(String fileName){
        JSONObject data = getJSONDataFromFile(fileName);

        Presentation presentation = new Presentation((String)((JSONObject)data.get("presentation")).get("filename"));

        List<Slide> slides = getSlidesFromJSON((JSONArray) ((JSONObject)data.get("presentation")).get("slides"));

        presentation.slides = slides;

        return presentation;
    }

    private List<Slide> getSlidesFromJSON(JSONArray data){
        List<Slide> returnData = new LinkedList<Slide>();

        data.forEach(slide -> addData(returnData,(JSONObject)slide));

        return returnData;
    }

    private void addData(List<Slide> data,JSONObject slide){
        data.add(new Slide((String)slide.get("title"),(String)slide.get("layout"),(String)slide.get("content")));
    }

}