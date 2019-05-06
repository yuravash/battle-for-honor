package game.modal.entities.units;


import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;



/**
 * Knight - melee fighters
 * @author Yura Vashkiv
 * @version 1.0
 * @since 27.04.2019
 */
public class Knight extends Unit{


    /* Unit characteristics */
    public final static int defaultHealth = 150;
    public final static int defaultDamage = 50;
    public final static int defaultRadiusOfAttack = 1;
    public final static int defaultTravelDistance = 1;


    public final static ResourceGroup price = new ResourceGroup(
            new Ore(50), new Gold(100), new Wood(0)
    );


    /**
     * Default constructor
     */
    public Knight(){
        super(defaultHealth, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }


    /**
     * Private constructor to copy
     * an object by method copy()
     * @param health This is current health count
     */
    private Knight(int health){
        super(health, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }


    /**
     * @see game.modal.entities.Copyable
     */
    @Override
    public Knight copy() {
        return new Knight(health);
    }


    @Override
    public String toString() {
        return "Knight("+super.toString()+")";
    }
}
