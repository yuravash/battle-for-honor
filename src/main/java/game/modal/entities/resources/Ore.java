package game.modal.entities.resources;


import game.exceptions.modal.entities.resources.ResourceTypeException;


/**
 * Ore - resource
 * @author Yura Vashkiv
 * @version 1.0
 * @since 07.05.2019
 */
public class Ore extends Resource{


    public Ore(){
        super(0);
    }


    public Ore(int value){
        super(value);
    }


    @Override
    public Ore add(Resource resource) throws ResourceTypeException {
        return (Ore)super.add(resource);
    }


    @Override
    public Ore sub(Resource resource) throws ResourceTypeException {
        return (Ore) super.sub(resource);
    }


    @Override
    public String toString() {
        return "Ore("+super.toString()+")";
    }
}
