package game.modal.entities.units;


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
