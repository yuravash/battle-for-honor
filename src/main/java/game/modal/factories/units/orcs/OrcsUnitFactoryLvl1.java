package game.modal.factories.units.orcs;

import game.exceptions.modal.entities.NotEnoughResourcesException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.modal.factories.units.AccessDeniedException;
import game.exceptions.modal.factories.units.UnitTypeException;

import game.modal.entities.battlefield.Cell;

import game.modal.entities.player.Player;

import game.modal.entities.units.Unit;
import game.modal.entities.units.UnitType;

import game.modal.entities.units.orcs.Berserk;

import game.modal.factories.units.UnitFactory;


public class OrcsUnitFactoryLvl1 implements UnitFactory {

    private static OrcsUnitFactoryLvl1 instance;

    private OrcsUnitFactoryLvl1(){}

    @Override
    public Unit getUnit(UnitType unitType, Cell position, Player owner) throws OccupiedCellException, UnitTypeException, AccessDeniedException, NotEnoughResourcesException {
        if (unitType != null){

            switch (unitType){

                case BERSERK:
                    return new Berserk(position, owner);

                case HEADHUNTER:
                case RIDER:
                    throw new AccessDeniedException();

            }
        }

        throw new UnitTypeException();
    }


    public static OrcsUnitFactoryLvl1 getInstance(){
        if(instance == null){
            instance = new OrcsUnitFactoryLvl1();
        }
        return instance;
    }
}
