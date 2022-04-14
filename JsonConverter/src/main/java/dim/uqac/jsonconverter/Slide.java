package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.SlideLayout;

public class Slide {
    private String title;
    private SlideLayout layout;
    private String content;

    //Constructor basic slide
    public Slide(String _title,SlideLayout _layout, String _content){
        title = _title;
        layout = _layout;
        content = _content;
    }

    public Slide(){
        title = "New Title";
        layout = null;
        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc maximus pellentesque elit, in viverra ligula viverra vitae. Ut elementum bibendum sem a tempus. Morbi sapien mauris, facilisis ut eleifend eget, lacinia et dolor. Nunc sollicitudin vitae nibh non venenatis. Nullam molestie lorem risus, vel mattis leo lacinia ut. Nam lacus dolor, feugiat vel mi ornare, feugiat dignissim justo. Sed euismod porta arcu ac consectetur. Ut at finibus ex. Nulla finibus tincidunt tincidunt. Nam dapibus semper maximus. Sed porttitor ex at ipsum vestibulum blandit. Nullam imperdiet fermentum nisl, in viverra felis ultrices ut. Fusce sollicitudin lectus et felis ullamcorper, ac malesuada lorem lobortis. Fusce gravida libero diam, sed laoreet odio imperdiet sed.";
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
    public String getLayout(){
        return layout;
    }
    //Setter for layout
    public void setLayout(String arg){
        layout = arg;
    }
    //Getter for content
    public String getContent(){
        return content;
    }
    //Setter for content
    public void setContent(String arg){
        content = arg;
    }
}