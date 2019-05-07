package game.exceptions.modal.entities.battlefield.cell;

public class OccupiedCellException extends Exception{
    public OccupiedCellException() {
        super("Occupied cell");
    }
}
