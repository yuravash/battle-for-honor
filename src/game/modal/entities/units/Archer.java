package game.modal.entities.units;


public class Archer extends Unit{

    final public static int defaultHealth = 100;
    final public static int defaultDamage = 50;
    final public static int defaultRadiusOfAttack = 2;
    final public static int defaultTravelDistance = 1;

    public Archer(){
        super(defaultHealth, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }

    private Archer(int health){
        super(health, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }

    @Override
    public Archer copy() {
        return new Archer(health);
    }

    @Override
    public String toString() {
        return "Archer("+super.toString()+")";
    }
}