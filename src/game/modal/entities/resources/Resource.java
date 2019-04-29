package game.modal.entities.resources;


import java.util.Objects;

import game.exceptions.entities.resources.ResourceTypeException;



public abstract class Resource {


    private int value;


    protected Resource(int value){
        this.value = value;
    }


    public int getValue(){
        return value;
    }


    public Resource add(Resource resource) throws ResourceTypeException{
        if (this.getClass() == resource.getClass()){
            this.value =+ resource.value;
            return this;
        }
        throw new ResourceTypeException();
    }


    public Resource sub(Resource resource) throws ResourceTypeException{
        if (this.getClass() == resource.getClass()){
            this.value =- resource.value;
            return this;
        }
        throw new ResourceTypeException();
    }


    @Override
    public boolean equals(Object obj) {
        return this == obj || (this.getClass() == obj.getClass() && this.value == ((Resource)obj).value);
    }


    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    @Override
    public String toString() {
        return "Resource: value=" + value;
    }
}
