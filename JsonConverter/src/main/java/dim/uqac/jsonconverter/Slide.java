package dim.uqac.jsonconverter;

public class Slide {
    private String title;
    private String layout;
    private String content;

    //Constructor basic slide
    public Slide(String _title,String _layout, String _content){
        title = _title;
        layout = _layout;
        content = _content;
    }

    //Getter for title
    public String GetTitle(){
        return title;
    }
    //Setter for title
    public void SetTitle(String arg){
        title = arg;
    }
    //Getter for layout
    public String GetLayout(){
        return layout;
    }
    //Setter for layout
    public void SetLayout(String arg){
        layout = arg;
    }
    //Getter for content
    public String GetContent(){
        return content;
    }
    //Setter for content
    public void SetContent(String arg){
        content = arg;
    }
}