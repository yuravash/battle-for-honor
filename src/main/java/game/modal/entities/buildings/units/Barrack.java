package game.modal.entities.buildings.units;


import game.exceptions.modal.entities.NotEnoughResourcesException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;

import game.modal.entities.battlefield.Cell;

import game.modal.entities.player.Player;

import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;

import game.modal.entities.units.RaceType;

import game.modal.factories.units.humans.HumansUnitFactoryLvl1;
import game.modal.factories.units.humans.HumansUnitFactoryLvl2;
import game.modal.factories.units.humans.HumansUnitFactoryLvl3;

import game.modal.factories.units.orcs.OrcsUnitFactoryLvl1;
import game.modal.factories.units.orcs.OrcsUnitFactoryLvl2;
import game.modal.factories.units.orcs.OrcsUnitFactoryLvl3;


public class Barrack extends UnitBuilding{

    public final static int defaultHealth = 500;

    public final static ResourceGroup price = new ResourceGroup(
            new Ore(200), new Gold(200), new Wood(200)
    );

    public BarrackLvl lvl = BarrackLvl.LVL1;


    public Barrack(Cell position, Player owner) throws OccupiedCellException, NotEnoughResourcesException {

        super(defaultHealth, position, owner);

        if(owner.getBalance().greater(price)){
            owner.getBalance().sub(price);
        }
        else{
            throw new NotEnoughResourcesException();
        }

        switch (owner.getRace()){
            case HUMANS:
                setUnitFactory(HumansUnitFactoryLvl1.getInstance());
                break;
            case ORCS:
                setUnitFactory(OrcsUnitFactoryLvl1.getInstance());
                break;
        }

    }

    public BarrackLvl getLvl(){
        return lvl;
    }

    public void updateLvl() throws NotEnoughResourcesException{

        switch (lvl){

            case LVL1:
                if(owner.getBalance().greater(BarrackLvl.LVL2.getPrice())){
                    owner.getBalance().sub(BarrackLvl.LVL2.getPrice());
                }
                else{
                    throw new NotEnoughResourcesException();
                }

                if (owner.getRace() == RaceType.HUMANS) {
                    setUnitFactory(HumansUnitFactoryLvl2.getInstance());
                }else{
                    setUnitFactory(OrcsUnitFactoryLvl2.getInstance());
                }
                break;

            case LVL2:
                if(owner.getBalance().greater(BarrackLvl.LVL3.getPrice())){
                    owner.getBalance().sub(BarrackLvl.LVL3.getPrice());
                }
                else{
                    throw new NotEnoughResourcesException();
                }

                if (owner.getRace() == RaceType.HUMANS) {
                    setUnitFactory(HumansUnitFactoryLvl3.getInstance());
                }else{
                    setUnitFactory(OrcsUnitFactoryLvl3.getInstance());
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "Barrack(" +
                super.toString() +
                ", lvl=" + lvl +
                ')';
    }


    public enum BarrackLvl{
        LVL1(null),
        LVL2(new ResourceGroup(new Ore(150), new Gold(150), new Wood(150))),
        LVL3(new ResourceGroup(new Ore(200), new Gold(200), new Wood(200)));

        private final ResourceGroup price;

        BarrackLvl(ResourceGroup price){
            this.price = price;
        }

        public ResourceGroup getPrice() {
            return price.copy();
        }
    }
}
