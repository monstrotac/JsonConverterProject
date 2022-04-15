package dim.uqac.jsonconverter;

public class Image implements Content{
    private String imageUrl;
    private int height;
    private int width;
    private int x;
    private int y;


    public Image(String imageUrl,int height,int width,int x,int y){
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getIdentity() {
        return "IMAGE";
    }
}
