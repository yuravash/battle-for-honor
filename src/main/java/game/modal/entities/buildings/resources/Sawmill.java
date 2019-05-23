package game.modal.entities.buildings.resources;


import game.exceptions.modal.entities.NotEnoughResourcesException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.modal.entities.resources.ResourceTypeException;
import game.modal.entities.battlefield.Cell;

import game.modal.entities.player.Player;

import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;


public class Sawmill extends ResourcesBuilding{

    public final static int defaultHealth = 400;

    private final static ResourceGroup resources = new ResourceGroup(
            new Ore(), new Gold(10), new Wood(40)
    );

    public final static ResourceGroup price = new ResourceGroup(
            new Ore(150), new Gold(150), new Wood(150)
    );


    public Sawmill(Cell position, Player owner) throws OccupiedCellException, NotEnoughResourcesException {
        super(defaultHealth, position, owner);
        if(owner.getBalance().greater(price)){
            owner.getBalance().sub(price);
        }
        else{
            throw new NotEnoughResourcesException();
        }
    }


    public static ResourceGroup getResources() {
        return resources.copy();
    }


    @Override
    public void generateResources() {
        try{
            owner.getBalance()
                    .add(resources)
                    .getWood()
                    .add(position.getBonusResources().getOre());
        }catch (ResourceTypeException e){}
    }


    @Override
    public String toString() {
        return "Sawmill("+super.toString()+", resources="+resources+")";
    }
}
