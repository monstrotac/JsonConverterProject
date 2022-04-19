package dim.uqac.jsonconverter;


/**
 * Image object implements the content Interface to fit in the ContentLists
 * @author Noah
 * @version 1.0
 */
public class Image implements Content{
    private String imageUrl;
    private int height;
    private int width;
    private int x;
    private int y;


    /**
     * @param imageUrl
     * @param height
     * @param width
     * @param x
     * @param y
     *
     * Constructor Of the Image object
     */
    public Image(String imageUrl,int height,int width,int x,int y){
        this.imageUrl = imageUrl;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for imageUrl
     * @return The image Url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Setter for imageUrl
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Getter for height
     * @return The height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter for height
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Getter for width
     * @return The width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setter for width
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Getter for x
     * @return The x
     */
    public int getX() {
        return x;
    }

    /**
     * Setter for x
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter for y
     * @return The y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter for y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter for the Image Identity
     * @return The Identity of the Image
     */
    @Override
    public String getIdentity() {
        return "IMAGE";
    }
}
