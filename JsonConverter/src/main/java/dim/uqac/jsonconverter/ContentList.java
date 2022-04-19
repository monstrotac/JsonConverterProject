package dim.uqac.jsonconverter;

/**
 * ContentList object implements the content Interface to fit in a ContentLists other than itself
 * @author Noah
 * @version 1.0
 */
public class ContentList implements Content{
    private java.util.List<Content> data;

    /**
     * Constructor of ContentList, it needs at least a basic List of Content, the data can be set later if needed
     * @param data
     */
    public ContentList(java.util.List<Content> data){
        this.data = data;
    }

    /**
     * Getter for the ContentList Identity
     * @return The Identity of the Object
     */
    @Override
    public String getIdentity() {
        return "LIST";
    }

    /**
     * Getter for data
     * @return The data of the Object
     */
    public java.util.List<Content> getData() {
        return data;
    }

    /**
     * Setter for data
     * @param data
     */
    public void setData(java.util.List<Content> data) {
        this.data = data;
    }
}
