package game.modal.entities.buildings.resources;


import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.modal.entities.battlefield.Cell;

import game.modal.entities.player.Player;

import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;


public class Castle extends ResourcesBuilding{

    public final static int defaultHealth = 1000;

    private final static ResourceGroup resources = new ResourceGroup(
            new Ore(10), new Gold(70), new Wood(10)
    );

    public final static ResourceGroup price = new ResourceGroup(
            new Ore(300), new Gold(300), new Wood(300)
    );


    public Castle(Cell position, Player owner) throws OccupiedCellException {
        super(defaultHealth, position, owner);
    }


    public static ResourceGroup getResources() {
        return resources.copy();
    }


    @Override
    public void generateResources() {
        owner.getBalance()
                .add(resources)
                .add(position.getBonusResources());
    }


    @Override
    public String toString() {
        return "Castle("+super.toString()+", resources="+resources+")";
    }
}