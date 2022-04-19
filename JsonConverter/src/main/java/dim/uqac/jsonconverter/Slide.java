package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.SlideLayout;

import java.util.List;

/**
 * Slide object implements the content Interface to fit in the ContentLists
 * @author Noah
 * @version 1.0
 */
public class Slide {
    private SlideLayout layout;
    private List<Content> content;

    /**
     * Constructor of a slide with parameters
     * @param _layout
     * @param _content
     */
    public Slide(SlideLayout _layout, List<Content> _content){
        layout = _layout;
        content = _content;
    }

    /**
     * Empty Constructor to generate Blank slides In case the JSON would have an empty Content
     */
    public Slide(){
        layout = SlideLayout.BLANK;
    }

    /**
     * Getter for layout
     * @return The Layout of the Slide
     */
    public SlideLayout getLayout(){
        return layout;
    }

    /**
     * Setter for layout
     * Set the Layout of the Slide
     * @param arg
     */
    public void setLayout(SlideLayout arg){
        layout = arg;
    }

    /**
     * Getter for content
     * @return The Content of the slide, List<Content>
     */
    public List<Content> getContent(){
        return content;
    }

    /**
     * Setter for content
     * @param arg
     */
    public void setContent(List<Content> arg){
        content = arg;
    }
}