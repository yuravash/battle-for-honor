package game.modal.entities.units;


public class Cavalry extends Unit{

    final public static int defaultHealth = 150;
    final public static int defaultDamage = 100;
    final public static int defaultRadiusOfAttack = 1;
    final public static int defaultTravelDistance = 2;

    public Cavalry(){
        super(defaultHealth, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }

    private Cavalry(int health){
        super(health, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }

    @Override
    public Cavalry copy() {
        return new Cavalry(health);
    }

    @Override
    public String toString() {
        return "Cavalry("+super.toString()+")";
    }
}