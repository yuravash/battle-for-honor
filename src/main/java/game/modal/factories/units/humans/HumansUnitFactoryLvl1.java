package game.modal.factories.units.humans;

import game.exceptions.modal.entities.NotEnoughResourcesException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.modal.factories.units.AccessDeniedException;
import game.exceptions.modal.factories.units.UnitTypeException;

import game.modal.entities.battlefield.Cell;

import game.modal.entities.player.Player;

import game.modal.entities.units.Unit;
import game.modal.entities.units.UnitType;

import game.modal.entities.units.humans.Knight;

import game.modal.factories.units.UnitFactory;

public class HumansUnitFactoryLvl1 implements UnitFactory {

    private static HumansUnitFactoryLvl1 instance;

    private HumansUnitFactoryLvl1(){}

    @Override
    public Unit getUnit(UnitType unitType, Cell position, Player owner) throws OccupiedCellException, UnitTypeException, AccessDeniedException, NotEnoughResourcesException {

        if (unitType != null){

            switch (unitType){

                case KNIGHT:
                    return new Knight(position, owner);

                case ARCHER:
                case CAVALRY:
                    throw new AccessDeniedException();

            }
        }

        throw new UnitTypeException();
    }


    public static HumansUnitFactoryLvl1 getInstance(){
        if(instance == null){
            instance = new HumansUnitFactoryLvl1();
        }
        return instance;
    }
}
