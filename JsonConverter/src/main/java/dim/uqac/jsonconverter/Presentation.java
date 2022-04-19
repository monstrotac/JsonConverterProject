package dim.uqac.jsonconverter;

import java.util.LinkedList;
import java.util.List;

/**
 * Object used in the PowerPointGenerator, is mainly used to store the Presentation Slides
 * @author Noah
 * @version 1.0
 */
public class Presentation {
    private String filename;


    public List<Slide> slides;

    /**
     * Constructor for a Presentation, only needs a filename since slides is public
     * @param _filename
     */
    public Presentation(String _filename){
        setFilename(_filename);
        slides = new LinkedList<Slide>();
    }


    /**
     * Getter for filename
     * @return The filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Setter for filename
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }
}