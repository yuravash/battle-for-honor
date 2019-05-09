package game.modal.entities.resources;


import game.exceptions.modal.entities.resources.ResourceTypeException;
import game.modal.entities.Copyable;


/**
 * Gold - resource
 * @author Yura Vashkiv
 * @version 1.0
 * @since 07.05.2019
 */
public class Gold extends Resource {


    public Gold(){
        super(0);
    }


    public Gold(int value){
        super(value);
    }


    @Override
    public Gold add(Resource resource) throws ResourceTypeException {
        return (Gold)super.add(resource);
    }


    @Override
    public Gold sub(Resource resource) throws ResourceTypeException {
        return (Gold)super.sub(resource);
    }


    @Override
    public String toString() {
        return "Gold("+super.toString()+")";
    }

    
    @Override
    public Gold copy() {
        return new Gold(value);
    }
}
