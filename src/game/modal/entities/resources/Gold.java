package game.modal.entities.resources;

import game.exceptions.entities.resources.ResourceTypeException;

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
}
