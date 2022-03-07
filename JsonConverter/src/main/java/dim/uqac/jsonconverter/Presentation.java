package dim.uqac.jsonconverter;

import java.util.LinkedList;
import java.util.List;

public class Presentation {
    private String filename;


    public List<Slide> slides;

    public Presentation(String _filename){
        setFilename(_filename);
        slides = new LinkedList<Slide>();
    }


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}