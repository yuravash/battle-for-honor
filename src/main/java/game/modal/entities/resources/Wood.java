package game.modal.entities.resources;


import game.exceptions.modal.entities.resources.ResourceTypeException;


/**
 * Wood - resource
 * @author Yura Vashkiv
 * @version 1.0
 * @since 07.05.2019
 */
public class Wood extends Resource{

    /**
     * Default constructor
     */
    public Wood(){
        super(0);
    }


    /**
     * Constructor
     * @param value amount of wood
     */
    public Wood(int value){
        super(value);
    }


    /**
     * Add resource value to current object's value of resource
     * @param resource Resource which value will be added
     * @return current object
     * @throws ResourceTypeException if type of param resource isn't Wood
     */
    @Override
    public Wood add(Resource resource) throws ResourceTypeException {
        return (Wood)super.add(resource);
    }


    /**
     * Subtract resource value from current object's value of resource
     * @param resource Resource which value will be subtracted from current object's value of resource
     * @return Current object
     * @throws ResourceTypeException if type of param resource isn't Wood
     */
    @Override
    public Wood sub(Resource resource) throws ResourceTypeException {
        return (Wood) super.sub(resource);
    }


    /**
     * Converts information about object to string
     * @see java.lang.Object
     * @return Converted object's information
     */
    @Override
    public String toString() {
        return "Wood("+super.toString()+")";
    }


    /**
     * Creates copied instance of current object
     * @see game.modal.entities.Copyable
     * @return Copied instance
     */
    @Override
    public Wood copy(){
        return new Wood(value);
    }
}
