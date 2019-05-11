package game.modal.entities.units;

import java.util.Objects;

public class Characteristics {

    private int damage;
    private int radiusOfAttack;
    private int travelDistance;

    public Characteristics(int damage, int radiusOfAttack, int travelDistance){
        this.damage = damage;
        this.radiusOfAttack = radiusOfAttack;
        this.travelDistance = travelDistance;
    }


    public int getDamage() {
        return damage;
    }

    public int getRadiusOfAttack() {
        return radiusOfAttack;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Characteristics)) return false;
        Characteristics that = (Characteristics) o;
        return damage == that.damage &&
                radiusOfAttack == that.radiusOfAttack &&
                travelDistance == that.travelDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(damage, radiusOfAttack, travelDistance);
    }
}
