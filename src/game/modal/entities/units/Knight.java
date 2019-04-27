package game.modal.entities.units;


public class Knight extends Unit{

    final public static int defaultHealth = 150;
    final public static int defaultDamage = 50;
    final public static int defaultRadiusOfAttack = 1;
    final public static int defaultTravelDistance = 1;

    public Knight(){
        super(defaultHealth, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }

    private Knight(int health){
        super(health, defaultDamage, defaultRadiusOfAttack, defaultTravelDistance);
    }

    @Override
    public Knight copy() {
        return new Knight(health);
    }

    @Override
    public String toString() {
        return "Knight("+super.toString()+")";
    }
}
