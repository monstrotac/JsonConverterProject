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

public class JSONReader{

    //Set the default path for the JSON files
    private final String FILE_IN_PATH = "src\\main\\resources\\InputFolder\\";
    private final String FILE_TYPE = ".json";

    public JSONReader (){

    }

    //Read a JSON file and return an array
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

    //This is the class that we call to Generate the Presentation with JSONReader.generatePresentation("...")
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

    //This function reads the JSONArray and makes slides
    private List<Slide> getSlidesFromJSON(JSONArray data){
        //Creates an empty temporary List
        List<Slide> returnData = new LinkedList<Slide>();

        //For each slide in the JSONObject, we add it to the data
        data.forEach(slide -> addData(returnData,(JSONObject)slide));

        return returnData;
    }

    //This function adds slides to the List of slides in returnData (for the presentation)
    private void addData(List<Slide> data,JSONObject slide){
        //Add to the data that was sent by reference
        List<Content> contents = new ArrayList<Content>();

        ((JSONArray)slide.get("content")).forEach(content -> getContent(contents,(JSONObject)content));

        data.add(new Slide(getLayout((String)slide.get("layout")),contents));
    }

    private void getContent(List<Content> data,JSONObject content){
        //Sets the content to the right type depending on the JSON object
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
        if(content.get("text") != null){
            JSONObject temp = (JSONObject)content.get("text");
            data.add(new Text((String)temp.get("data"),getColor((String)temp.get("color")),(String)temp.get("font"), (double)temp.get("size")));
            checkDecorationText(temp,(Text)data.get(data.size() - 1));
        }
        if(content.get("image") != null){
            JSONObject temp = (JSONObject)content.get("image");
            data.add(new Image((String)temp.get("imageUrl"),
                    (int)temp.get("height"),
                    (int)temp.get("width"),
                    (int)temp.get("x"),
                    (int)temp.get("y")));
        }

        if(content.get("list") != null){
            JSONObject temp = (JSONObject)content.get("list");
            List<Content> texts = new ArrayList<Content>();
            ((JSONArray)temp.get("content")).forEach(listObject -> getContent(texts,(JSONObject) listObject));
            //oui
            data.add(new ContentList(texts));
            System.out.println("");
        }
    }

    private void checkDecorationTitle(JSONObject temp,Title data){
        if(temp.get("decorations") != null){
            JSONObject deco = (JSONObject)temp.get("decorations");

            if((boolean) deco.get("bold")){data.setBold(true);}
            if((boolean) deco.get("italic")){data.setItalic(true);}
            if((boolean) deco.get("underlined")){data.setUnderlined(true);}
            if((boolean) deco.get("strikethrough")){data.setStrikethrough(true);}

        }
    }

    private void checkDecorationText(JSONObject temp,Text data){
        if(temp.get("decorations") != null){
            JSONObject deco = (JSONObject)temp.get("decorations");

            if((boolean) deco.get("bold")){data.setBold(true);}
            if((boolean) deco.get("italic")){data.setItalic(true);}
            if((boolean) deco.get("underlined")){data.setUnderlined(true);}
            if((boolean) deco.get("strikethrough")){data.setStrikethrough(true);}

        }
    }

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

    private SlideLayout getLayout(String layout){
        //Gets the layout type and returns it
        if(Objects.equals(layout, "TITLE")){
            return SlideLayout.TITLE;
        }
        else if(Objects.equals(layout, "TEXT_AND_CHART")){
            return SlideLayout.TEXT_AND_CHART;
        }
        else if(Objects.equals(layout, "CHART_AND_TEXT")){
            return SlideLayout.CHART_AND_TEXT;
        }
        else if(Objects.equals(layout, "TITLE_AND_CONTENT")){
            return SlideLayout.TITLE_AND_CONTENT;
        }
        else{
            return SlideLayout.BLANK;
        }
    }

}