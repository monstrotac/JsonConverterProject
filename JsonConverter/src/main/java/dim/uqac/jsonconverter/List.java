package dim.uqac.jsonconverter;

public class List implements Content{
    private java.util.List<Content> data;

    public List(java.util.List<Content> data){
        this.data = data;
    }

    @Override
    public String getIdentity() {
        return "LIST";
    }
}