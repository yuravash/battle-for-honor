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
import game.modal.entities.units.orcs.Headhunter;

import game.modal.entities.units.orcs.Rider;

import game.modal.factories.units.UnitFactory;


public class OrcsUnitFactoryLvl3 implements UnitFactory {

    private static OrcsUnitFactoryLvl3 instance;

    private OrcsUnitFactoryLvl3(){}

    @Override
    public Unit getUnit(UnitType unitType, Cell position, Player owner) throws OccupiedCellException, UnitTypeException, NotEnoughResourcesException {
        if (unitType != null){

            switch (unitType){

                case BERSERK:
                    return new Berserk(position, owner);

                case HEADHUNTER:
                    return new Headhunter(position, owner);

                case RIDER:
                    return new Rider(position, owner);

            }
        }

        throw new UnitTypeException();
    }


    public static OrcsUnitFactoryLvl3 getInstance(){
        if(instance == null){
            instance = new OrcsUnitFactoryLvl3();
        }
        return instance;
    }
}
