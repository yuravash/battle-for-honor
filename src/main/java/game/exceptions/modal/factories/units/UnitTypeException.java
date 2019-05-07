package game.exceptions.modal.factories.units;

public class UnitTypeException extends Exception{
    public UnitTypeException(){
        super("Factory doesn't support that unit type");
    }
}
