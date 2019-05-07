package game.modal.entities.units.orcs;

import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;
import game.modal.entities.units.Unit;


/**
 * Rider - strong melee fighters,
 * special ability - travel distance equals 2 cells
 * @author Yura Vashkiv
 * @version 1.0
 * @since 07.05.2019
 */
public class Rider extends Unit {

    /* Unit characteristics */
    public final static int defaultHealth = 125;
    public final static int defaultDamage = 125;
    public final static int defaultRadiusOfAttack = 1;
    public final static int defaultTravelDistance = 2;


    public final static ResourceGroup price = new ResourceGroup(
            new Ore(50), new Gold(100), new Wood(0)
    );


    /**
     * Default constructor
     */
    public Rider(){
        super(defaultHealth, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }


    /**
     * Private constructor to copy
     * an object by method copy()
     * @param health This is current health count
     */
    private Rider(int health){
        super(health, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }


    /**
     * @see game.modal.entities.Copyable
     */
    @Override
    public Rider copy() {
        return new Rider(health);
    }


    @Override
    public String toString() {
        return "Berserk("+super.toString()+")";
    }
}
