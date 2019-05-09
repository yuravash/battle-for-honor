package game.modal.entities.resources;


import java.util.Objects;

import game.exceptions.modal.entities.resources.ResourceTypeException;

import game.modal.entities.Copyable;


/**
 * Resource - abstract class which realise
 * operation add, sub, equals for all resource types
 * @author Yura Vashkiv
 * @version 1.0
 * @since 07.05.2019
 */
public abstract class Resource implements Copyable {


    protected int value;


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
