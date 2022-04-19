package dim.uqac.jsonconverter;

import java.awt.*;

/**
 * Text object implements the content Interface to fit in the ContentLists
 * @author Noah
 * @version 1.0
 */
public class Text implements Content {
    private String data;
    private Color color;
    private String font;
    private double size;
    private boolean bold = false;
    private boolean italic = false;
    private boolean underlined = false;
    private boolean strikethrough = false;

    /**
     * Constructor for the Text objet, doesn't need the decorations since they are false by default and only set if needed
     * @param data
     * @param color
     * @param font
     * @param size
     */
    public Text(String data, Color color, String font, double size){
        this.data = data;
        this.color = color;
        this.font = font;
        this.size = size;
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
     * Getter for the Text Identity
     * @return The object Identity
     */
    @Override
    public String getIdentity() {
        return "TEXT";
    }
}
