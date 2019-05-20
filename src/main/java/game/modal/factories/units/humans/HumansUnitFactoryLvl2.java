package game.modal.factories.units.humans;


import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.modal.factories.units.AccessDeniedException;
import game.exceptions.modal.factories.units.UnitTypeException;

import game.modal.entities.battlefield.Cell;

import game.modal.entities.player.Player;

import game.modal.entities.units.Unit;
import game.modal.entities.units.UnitType;

import game.modal.entities.units.humans.Archer;
import game.modal.entities.units.humans.Knight;

import game.modal.factories.units.UnitFactory;


public class HumansUnitFactoryLvl2 implements UnitFactory {

    @Override
    public Unit getUnit(UnitType unitType, Cell position, Player owner) throws OccupiedCellException, UnitTypeException, AccessDeniedException {

        if (unitType != null){

            switch (unitType){

                case KNIGHT:
                    return new Knight(position, owner);

                case ARCHER:
                    return new Archer(position, owner);

                case CAVALRY:
                    throw new AccessDeniedException();
            }
        }
        throw new UnitTypeException();
    }
}
