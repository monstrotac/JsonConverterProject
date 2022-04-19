package dim.uqac.jsonconverter;

/**
 * Interface used to give a basic Identity to the other Contents like TEXT or IMAGE
 * @author Noah
 * @version 1.0
 */
public interface Content {

    /**
     * Getter for the Identities
     * @return The identity of the Object used, needs to be Overwritten
     */
    public String getIdentity();
}
