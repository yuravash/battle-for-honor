package game.modal.entities.units;


/* Libs */
import java.util.Objects;

import game.exceptions.entities.battlefield.cell.AccessDeniedException;
import game.exceptions.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.entities.units.ExceedDistanceException;
import game.modal.entities.battlefield.Cell;


/**
 * Unit - abstract class which realise
 * characteristics and abilities of all units
 * @author Yura Vashkiv
 * @version 1.0
 * @since 27.04.2019
 */
public abstract class Unit {


    protected static int lastId = 0;


    protected int id;
    protected int health;
    protected int damage;
    protected int radiusOfAttack;
    protected int travelDistance;
    protected Cell position;


    protected Unit(int health, int damage, int radiusOfAttack, int travelDistance, Cell position) throws OccupiedCellException{
        this.id = ++lastId;
        this.health = health;
        this.damage = damage;
        this.radiusOfAttack = radiusOfAttack;
        this.travelDistance = travelDistance;

        position.setUnit(this);
        this.position = position;
    }

    /* TODO: add attacking, decreasing health */

    /**
     * Move unit to other cell
     * @param position New unit position
     * @throws ExceedDistanceException if exceed distance to cell
     * @throws OccupiedCellException if new position is occupied by another unit
     */
    public void move(Cell position) throws ExceedDistanceException, OccupiedCellException {
        if (this.position != position) {
            if (position.getPosX() >= (this.position.getPosX() - travelDistance) &&
                    position.getPosX() <= (this.position.getPosX() + travelDistance) &&
                    position.getPosY() >= (this.position.getPosY() - travelDistance) &&
                    position.getPosY() <= (this.position.getPosY() + travelDistance)) {

                position.setUnit(this);
                try {this.position.removeUnit(this);} catch (AccessDeniedException e) {}
                this.position = position;

            } else {
                throw new ExceedDistanceException();
            }
        }
    }


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

    public Cell getPosition() {
        return position;
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
