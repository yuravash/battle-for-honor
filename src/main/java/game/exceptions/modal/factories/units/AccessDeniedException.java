package game.exceptions.modal.factories.units;

public class AccessDeniedException extends Exception{
    public AccessDeniedException() {
        super("Access denied for creating this type of units");
    }
}
