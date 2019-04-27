package game.modal.entities.units;


/**
 * Archer - long distance fighters
 * @author Yura Vashkiv
 * @version 1.0
 * @since 27.04.2019
 */
public class Archer extends Unit{

    /* Unit characteristics */
    public final static int defaultHealth = 100;
    public final static int defaultDamage = 50;
    public final static int defaultRadiusOfAttack = 2;
    public final static int defaultTravelDistance = 1;

    /**
     * Default constructor
     */
    public Archer(){
        super(defaultHealth, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }

    /**
     * Private constructor to copy
     * an object by method copy()
     * @param health This is current health count
     */
    private Archer(int health){
        super(health, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }

    /**
     * @see game.modal.entities.Copyable
     */
    @Override
    public Archer copy() {
        return new Archer(health);
    }

    @Override
    public String toString() {
        return "Archer("+super.toString()+")";
    }
}