package dim.uqac.jsonconverter;

public class Text implements Content {
    private String data;
    private String color;
    private String font;
    private int size;

    public Text(String data,String color,String font,int size){
        this.data = data;
        this.color = color;
        this.font = font;
        this.size = size;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
