package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.SlideLayout;

import java.util.List;

public class Slide {
    private SlideLayout layout;
    private List<Content> content;

    //Constructor basic slide
    public Slide(SlideLayout _layout, List<Content> _content){
        layout = _layout;
        content = _content;
    }

    public Slide(){
        layout = SlideLayout.BLANK;
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