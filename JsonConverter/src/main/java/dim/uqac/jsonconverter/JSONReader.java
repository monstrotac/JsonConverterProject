package dim.uqac.jsonconverter;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Object with most of the JSON functionality, creates the presentation Objects
 * @author Noah
 * @version 1.0
 */
public class JSONReader{

    //Set the default path for the JSON files
    private final String FILE_IN_PATH = "src\\main\\resources\\InputFolder\\";
    private final String FILE_TYPE = ".json";

    /**
     * Blank Constructor to use the generatePresentation function
     */
    public JSONReader (){

    }

    /**
     * This function gets is the File Reader of the JSONReader, Only used to read the JSON file
     * @param fileName
     * @return A JSON object created by reading the file sent in the parameters
     */
    private JSONObject getJSONDataFromFile(String fileName){
        //Set the json parser
        JSONParser jsonParser = new JSONParser();
        //Set the return data
        JSONObject data = null;

        //Try catch since we are in a filereader
        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            //Set the data we use as a JSONObject
            data = (JSONObject) obj;

        } catch (FileNotFoundException e) {
            //Catch if the file is not found
            e.printStackTrace();
        } catch (IOException e) {
            //Catch if the file has an error while reading it
            e.printStackTrace();
        } catch (ParseException e) {
            //Catch if the JSON has a bad format
            e.printStackTrace();
        }
        return data;
    }

    /**
     * This is the function called to create a Presentation out of the JSONReader Object
     * @param fileName
     * @return A presentation used by the powerpoint Generator
     */
    public Presentation generatePresentation(String fileName){
        //Creates the JSONObject from the file
        JSONObject data = getJSONDataFromFile(FILE_IN_PATH+fileName+FILE_TYPE);

        //Creates a new Presentation without slides
        Presentation presentation = new Presentation((String)((JSONObject)data.get("presentation")).get("filename"));

        //Creates the slides from the JSONObject
        List<Slide> slides = getSlidesFromJSON((JSONArray) ((JSONObject)data.get("presentation")).get("slides"));

        //Adds the slides to the presentation
        presentation.slides = slides;

        return presentation;
    }

    /**
     * This function reads the JSONArray and makes slides
     * @param data
     * @return slides from the array
     */
    private List<Slide> getSlidesFromJSON(JSONArray data){
        //Creates an empty temporary List
        List<Slide> returnData = new LinkedList<Slide>();

        //For each slide in the JSONObject, we add it to the data
        data.forEach(slide -> addData(returnData,(JSONObject)slide));

        return returnData;
    }

    /**
     * This function adds slides to the List of slides in returnData (for the presentation)
     * @param data
     * @param slide
     */
    private void addData(List<Slide> data,JSONObject slide){
        //Add to the data that was sent by reference
        List<Content> contents = new ArrayList<Content>();

        ((JSONArray)slide.get("content")).forEach(content -> getContent(contents,(JSONObject)content));

        data.add(new Slide(getLayout((String)slide.get("layout")),contents));
    }

    /**
     * Sets the content to the right type depending on the JSON object
     * @param data
     * @param content
     */
    private void getContent(List<Content> data,JSONObject content){

        //Title
        if(content.get("title") != null){
            JSONObject temp = (JSONObject)content.get("title");
            if(temp.get("size") != null){
                data.add(new Title((String)temp.get("data"),getColor((String)temp.get("color")),(String)temp.get("font"), (double)temp.get("size")));
            }
            else{
                data.add(new Title((String)temp.get("data"),getColor((String)temp.get("color")),(String)temp.get("font")));
            }
            checkDecorationTitle(temp,(Title)data.get(data.size() - 1));
        }
        //Text
        if(content.get("text") != null){
            JSONObject temp = (JSONObject)content.get("text");
            data.add(new Text((String)temp.get("data"),getColor((String)temp.get("color")),(String)temp.get("font"), (double)temp.get("size")));
            checkDecorationText(temp,(Text)data.get(data.size() - 1));
        }
        //Image
        if(content.get("image") != null){
            JSONObject temp = (JSONObject)content.get("image");
            data.add(new Image((String)temp.get("imageUrl"),
                    Integer.parseInt((String)temp.get("height")),
                    Integer.parseInt((String)temp.get("width")),
                    Integer.parseInt((String)temp.get("x")),
                    Integer.parseInt((String)temp.get("y"))));
        }
        //List
        if(content.get("list") != null){
            JSONObject temp = (JSONObject)content.get("list");
            List<Content> texts = new ArrayList<Content>();
            ((JSONArray)temp.get("content")).forEach(listObject -> getContent(texts,(JSONObject) listObject));
            data.add(new ContentList(texts));
            System.out.println("");
        }
    }

    /**
     * Checks the Decoration of the text for a Title
     * @param temp
     * @param data
     */
    private void checkDecorationTitle(JSONObject temp,Title data){
        if(temp.get("decorations") != null){
            JSONObject deco = (JSONObject)temp.get("decorations");

            if((boolean) deco.get("bold")){data.setBold(true);}
            if((boolean) deco.get("italic")){data.setItalic(true);}
            if((boolean) deco.get("underlined")){data.setUnderlined(true);}
            if((boolean) deco.get("strikethrough")){data.setStrikethrough(true);}

        }
    }

    /**
     * Checks the Decoration of the text for a Text
     * @param temp
     * @param data
     */
    private void checkDecorationText(JSONObject temp,Text data){
        if(temp.get("decorations") != null){
            JSONObject deco = (JSONObject)temp.get("decorations");

            if((boolean) deco.get("bold")){data.setBold(true);}
            if((boolean) deco.get("italic")){data.setItalic(true);}
            if((boolean) deco.get("underlined")){data.setUnderlined(true);}
            if((boolean) deco.get("strikethrough")){data.setStrikethrough(true);}

        }
    }

    /**
     * Transfers the color from a string to an Object
     * @param color
     * @return The color in a Color.(...)
     */
    private Color getColor(String color){
        switch (color){
            case "white" ->{return Color.white;}
            case "lightGray" -> {return Color.lightGray;}
            case "gray" -> {return Color.gray;}
            case "darkGray" -> {return Color.darkGray;}
            case "black" -> {return Color.black;}
            case "red" -> {return Color.red;}
            case "pink" -> {return Color.pink;}
            case "orange" -> {return Color.orange;}
            case "yellow" -> {return Color.yellow;}
            case "green" -> {return Color.green;}
            case "magenta" -> {return Color.magenta;}
            case "cyan" -> {return Color.cyan;}
            case "blue" -> {return Color.blue;}
            default -> {return Color.black;}
        }
    }

    /**
     * Gets the layout type and returns it as a SlideLayout
     * @param layout
     * @return a SlideLayout
     */
    private SlideLayout getLayout(String layout){
        //
        if(Objects.equals(layout, "TITLE_ONLY")){
            return SlideLayout.TITLE_ONLY;
        }
        else if(Objects.equals(layout, "TITLE_AND_CONTENT")){
            return SlideLayout.TITLE_AND_CONTENT;
        }
        else{
            return SlideLayout.BLANK;
        }
    }

}