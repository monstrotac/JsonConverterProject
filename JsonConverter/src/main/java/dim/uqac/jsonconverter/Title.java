package dim.uqac.jsonconverter;

import java.awt.*;

public class Title implements Content {
    private String data;
    private Color color;
    private String font;
    private double size;

    public Title(String data, Color color, String font, double size){
        this.data = data;
        this.color = color;
        this.font = font;
        this.size = size;
    }

    public Title(String data, Color color, String font){
        this.data = data;
        this.color = color;
        this.font = font;
        this.size = 44.0;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String getIdentity() {
        return "TITLE";
    }
}
