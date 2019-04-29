package game.modal.entities.units;

/* Libs */
import java.util.Objects;

import game.modal.entities.Copyable;


/**
 * Unit - abstract class which realise
 * characteristics and abilities of all units
 * @author Yura Vashkiv
 * @version 1.0
 * @since 27.04.2019
 */
public abstract class Unit implements Copyable {

    protected static int lastId = 0;

    protected int id;
    protected int health;
    protected int damage;
    protected int radiusOfAttack;
    protected int travelDistance;
    /* TODO: add position */

    Unit(int health, int damage, int radiusOfAttack, int travelDistance){
        this.id = ++lastId;
        this.health = health;
        this.damage = damage;
        this.radiusOfAttack = radiusOfAttack;
        this.travelDistance = travelDistance;
    }
    /* TODO: add attacking, decreasing health, moving */
    public boolean isAlive(){
        return health > 0;
    }

    public int getId() {
        return id;
    }

    public static int getLastId() {
        return lastId;
    }

    public int getHealth() {
        return health;
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
    public String toString() {
        return "Unit: id="+id+", health="+health+", damage="+damage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, health, damage, radiusOfAttack, travelDistance);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (this.getClass() == obj.getClass() && this.id == ((Unit)obj).id);
    }
}
