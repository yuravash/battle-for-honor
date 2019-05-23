package game.modal.entities.units.humans;


import game.exceptions.modal.entities.NotEnoughResourcesException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.modal.entities.battlefield.Cell;
import game.modal.entities.player.Player;
import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;
import game.modal.entities.units.Unit;


/**
 * Archer - long distance fighters
 * @author Yura Vashkiv
 * @version 1.0
 * @since 27.04.2019
 */
public class Archer extends Unit {


    /* Unit characteristics */
    public final static int defaultHealth = 100;
    public final static int defaultDamage = 50;
    public final static int defaultRadiusOfAttack = 2;
    public final static int defaultTravelDistance = 1;


    public final static ResourceGroup price = new ResourceGroup(
            new Ore(75), new Gold(100), new Wood(50)
    );


    /**
     * Constructor
     * @param position Unit position
     */
    public Archer(Cell position, Player owner) throws OccupiedCellException, NotEnoughResourcesException{
        super(defaultHealth, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance, position, owner);
        if(owner.getBalance().greater(price)){
            owner.getBalance().sub(price);
        }
        else{
            throw new NotEnoughResourcesException();
        }
    }


    @Override
    public String toString() {
        return "Archer("+super.toString()+")";
    }
}