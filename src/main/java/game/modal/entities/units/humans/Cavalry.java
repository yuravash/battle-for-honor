package game.modal.entities.units.humans;


import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;
import game.modal.entities.units.Unit;


/**
 * Cavalry - strong melee fighters,
 * special ability - travel distance equals 2 cells
 * @author Yura Vashkiv
 * @version 1.0
 * @since 27.04.2019
 */
public class Cavalry extends Unit {


    /* Unit characteristics */
    public final static int defaultHealth = 150;
    public final static int defaultDamage = 100;
    public final static int defaultRadiusOfAttack = 1;
    public final static int defaultTravelDistance = 2;


    public final static ResourceGroup price = new ResourceGroup(
            new Ore(100), new Gold(250), new Wood(0)
    );


    /**
     * Default constructor
     */
    public Cavalry(){
        super(defaultHealth, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }


    /**
     * Private constructor to copy
     * an object by method copy()
     * @param health This is current health count
     */
    private Cavalry(int health){
        super(health, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }


    /**
     * @see game.modal.entities.Copyable
     */
    @Override
    public Cavalry copy() {
        return new Cavalry(health);
    }


    @Override
    public String toString() {
        return "Cavalry("+super.toString()+")";
    }
}