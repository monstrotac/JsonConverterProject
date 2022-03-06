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