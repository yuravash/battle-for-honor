package game.modal.entities.resources;


import game.exceptions.entities.resources.ResourceTypeException;



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
}
