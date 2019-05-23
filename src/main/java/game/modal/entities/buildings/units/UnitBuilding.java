package game.modal.entities.buildings.units;


import game.exceptions.modal.entities.NotEnoughResourcesException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;

import game.exceptions.modal.factories.units.AccessDeniedException;
import game.exceptions.modal.factories.units.UnitTypeException;
import game.modal.entities.battlefield.Cell;

import game.modal.entities.buildings.Building;

import game.modal.entities.player.Player;
import game.modal.entities.units.Unit;
import game.modal.entities.units.UnitType;
import game.modal.factories.units.UnitFactory;



public abstract class UnitBuilding extends Building {

    protected UnitFactory unitFactory;


    protected UnitBuilding(int health, Cell position, Player owner) throws OccupiedCellException {
        super(health, position, owner);
    }

    protected void setUnitFactory(UnitFactory factory){
        this.unitFactory = unitFactory;
    }

    public Unit createUnit(UnitType type, Player player) throws OccupiedCellException, UnitTypeException, AccessDeniedException, NotEnoughResourcesException {
        return unitFactory.getUnit(type, position, player);
    }


    @Override
    public String toString() {
        return "UnitBuilding("+super.toString()+")";
    }

}
