package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.SlideLayout;

import java.util.List;

public class Slide {
    private String title;
    private SlideLayout layout;
    private List<Content> content;

    //Constructor basic slide
    public Slide(String _title,SlideLayout _layout, List<Content> _content){
        title = _title;
        layout = _layout;
        content = _content;
    }

    public Slide(){
        title = "New Title";
        layout = SlideLayout.BLANK;
    }

    //Getter for title
    public String getTitle(){
        return title;
    }
    //Setter for title
    public void setTitle(String arg){
        title = arg;
    }
    //Getter for layout
    public SlideLayout getLayout(){
        return layout;
    }
    //Setter for layout
    public void setLayout(SlideLayout arg){
        layout = arg;
    }
    //Getter for content
    public List<Content> getContent(){
        return content;
    }
    //Setter for content
    public void setContent(List<Content> arg){
        content = arg;
    }
}