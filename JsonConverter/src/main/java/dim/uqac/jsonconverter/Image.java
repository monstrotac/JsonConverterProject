package dim.uqac.jsonconverter;

public class Image implements Content{
    private String imageUrl;
    private float height;
    private float width;
    private float x;
    private float y;


    public Image(String imageUrl,float height,float width,float x,float y){
        this.imageUrl = imageUrl;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
