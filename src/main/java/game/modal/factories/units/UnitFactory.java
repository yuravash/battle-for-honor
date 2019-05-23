package game.modal.factories.units;

import game.exceptions.modal.entities.NotEnoughResourcesException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.modal.factories.units.AccessDeniedException;
import game.exceptions.modal.factories.units.UnitTypeException;
import game.modal.entities.battlefield.Cell;
import game.modal.entities.player.Player;
import game.modal.entities.units.Unit;
import game.modal.entities.units.UnitType;

public interface UnitFactory {
    Unit getUnit(UnitType unitType, Cell position, Player owner) throws OccupiedCellException, UnitTypeException, AccessDeniedException, NotEnoughResourcesException;
}
