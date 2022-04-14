package dim.uqac.jsonconverter;

import org.json.simple.JSONObject;

import java.awt.*;

public class Title implements Content {
    private String data;
    private Color color;
    private String font;
    private double size;
    private boolean bold = false;
    private boolean italic = false;
    private boolean underlined = false;
    private boolean strikethrough = false;

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

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public boolean isUnderlined() {
        return underlined;
    }

    public void setUnderlined(boolean underlined) {
        this.underlined = underlined;
    }

    public boolean isStrikethrough() {
        return strikethrough;
    }

    public void setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    @Override
    public String getIdentity() {
        return "TITLE";
    }
}
