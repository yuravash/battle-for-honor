package game.exceptions.modal.entities.units;

public class ExceedDistanceException  extends Exception {
    public ExceedDistanceException() {
        super("Exceed distance for doing action");
    }
}
