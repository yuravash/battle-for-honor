package game.modal.factories.units;


import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.modal.factories.units.UnitTypeException;
import game.modal.entities.battlefield.Cell;
import game.modal.entities.units.Unit;
import game.modal.entities.units.UnitType;
import game.modal.entities.units.orcs.Berserk;
import game.modal.entities.units.orcs.Headhunter;
import game.modal.entities.units.orcs.Rider;


public class OrcsUnitFactory implements UnitFactory {

    @Override
    public Unit getUnit(UnitType unitType, Cell position) throws OccupiedCellException, UnitTypeException {
        if (unitType != null){
            switch (unitType){
                case BERSERK:
                    return new Berserk(position);
                case HEADHUNTER:
                    return new Headhunter(position);
                case RIDER:
                    return new Rider(position);
            }
        }
        throw new UnitTypeException();
    }
}
