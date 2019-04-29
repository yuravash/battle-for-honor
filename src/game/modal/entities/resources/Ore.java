package game.modal.entities.resources;

import game.exceptions.entities.resources.ResourceTypeException;

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
}
