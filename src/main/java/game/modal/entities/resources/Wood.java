package game.modal.entities.resources;


import game.exceptions.modal.entities.resources.ResourceTypeException;


/**
 * Wood - resource
 * @author Yura Vashkiv
 * @version 1.0
 * @since 07.05.2019
 */
public class Wood extends Resource{


    public Wood(){
        super(0);
    }


    public Wood(int value){
        super(value);
    }


    @Override
    public Wood add(Resource resource) throws ResourceTypeException {
        return (Wood)super.add(resource);
    }


    @Override
    public Wood sub(Resource resource) throws ResourceTypeException {
        return (Wood) super.sub(resource);
    }


    @Override
    public String toString() {
        return "Wood("+super.toString()+")";
    }


    @Override
    public Wood copy(){
        return new Wood(value);
    }
}
