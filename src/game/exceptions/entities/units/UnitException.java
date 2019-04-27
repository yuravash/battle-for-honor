package game.exceptions.entities.units;

public class UnitException extends Exception {
    public UnitException() {
        super("Unit was killed");
    }
}
