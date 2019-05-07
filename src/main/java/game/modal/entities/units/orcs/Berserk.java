package game.modal.entities.units.orcs;

import game.exceptions.entities.battlefield.cell.OccupiedCellException;
import game.modal.entities.battlefield.Cell;
import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;
import game.modal.entities.units.Unit;


/**
 * Berserk - melee fighters
 * @author Yura Vashkiv
 * @version 1.0
 * @since 07.05.2019
 */
public class Berserk extends Unit{

    /* Unit characteristics */
    public final static int defaultHealth = 125;
    public final static int defaultDamage = 75;
    public final static int defaultRadiusOfAttack = 1;
    public final static int defaultTravelDistance = 1;


    public final static ResourceGroup price = new ResourceGroup(
            new Ore(50), new Gold(100), new Wood(0)
    );


    /**
     * Constructor
     * @param position Unit position
     */
    public Berserk(Cell position) throws OccupiedCellException{
        super(defaultHealth, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance, position);
    }


    @Override
    public String toString() {
        return "Berserk("+super.toString()+")";
    }
}
