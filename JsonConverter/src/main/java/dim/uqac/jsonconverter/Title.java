package dim.uqac.jsonconverter;

import org.json.simple.JSONObject;

import java.awt.*;

/**
 * Title object implements the content Interface to fit in the ContentLists, Title is also another version of the Text Object
 * @author Noah
 * @version 1.0
 */
public class Title implements Content {
    private String data;
    private Color color;
    private String font;
    private double size;
    private boolean bold = false;
    private boolean italic = false;
    private boolean underlined = false;
    private boolean strikethrough = false;

    /**
     * Constructor with the Size
     * @param data
     * @param color
     * @param font
     * @param size
     */
    public Title(String data, Color color, String font, double size){
        this.data = data;
        this.color = color;
        this.font = font;
        this.size = size;

    }

    /**
     * Constructor without the Size, in that case the size will be the default PowerPoint Title Size
     * @param data
     * @param color
     * @param font
     */
    public Title(String data, Color color, String font){
        this.data = data;
        this.color = color;
        this.font = font;
        this.size = 44.0;
    }

    /**
     * Getter for data
     * @return data
     */
    public String getData() {
        return data;
    }

    /**
     * Setter for data
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Getter for color
     * @return The color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter for color
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Getter for font
     * @return The font
     */
    public String getFont() {
        return font;
    }

    /**
     * Setter for font
     * @param font
     */
    public void setFont(String font) {
        this.font = font;
    }

    /**
     * Getter for size
     * @return The size
     */
    public double getSize() {
        return size;
    }

    /**
     * Setter for size
     * @param size
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Getter for bold
     * @return if bold
     */
    public boolean isBold() {
        return bold;
    }

    /**
     * Setter for bold
     * @param bold
     */
    public void setBold(boolean bold) {
        this.bold = bold;
    }

    /**
     * Getter for italic
     * @return if italic
     */
    public boolean isItalic() {
        return italic;
    }

    /**
     * Setter for italic
     * @param italic
     */
    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    /**
     * Getter for underlined
     * @return if underlined
     */
    public boolean isUnderlined() {
        return underlined;
    }

    /**
     * Setter for underlined
     * @param underlined
     */
    public void setUnderlined(boolean underlined) {
        this.underlined = underlined;
    }

    /**
     * Getter for strikethrough
     * @return if strikethrough
     */
    public boolean isStrikethrough() {
        return strikethrough;
    }

    /**
     * Setter for strikethrough
     * @param strikethrough
     */
    public void setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    /**
     * Getter for the Title Identity
     * @return The object Identity
     */
    @Override
    public String getIdentity() {
        return "TITLE";
    }
}
