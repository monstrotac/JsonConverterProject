package dim.uqac.jsonconverter;

public class Image implements Content{
    private String imageUrl;
    private double height;
    private double width;
    private double x;
    private double y;


    public Image(String imageUrl,double height,double width,double x,double y){
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
