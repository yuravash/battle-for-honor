package game.modal.entities.units;


/* Libs */
import java.util.Objects;

import game.exceptions.modal.entities.battlefield.cell.AccessDeniedException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.modal.entities.units.ExceedDistanceException;
import game.modal.entities.battlefield.Cell;
import game.modal.factories.characteristics.CharacteristicsFactory;


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

    protected Characteristics characteristics;

    protected Cell position;


    protected Unit(int health, int damage, int radiusOfAttack, int travelDistance, Cell position) throws OccupiedCellException{
        this.id = ++lastId;
        this.health = health;
        this.characteristics = CharacteristicsFactory.getInstance()
                .getCharacteristics(damage, radiusOfAttack, travelDistance);

        position.setUnit(this);
        this.position = position;
    }


    /**
     * Move unit to other cell
     * @param position New unit position
     * @throws ExceedDistanceException if exceed distance to cell
     * @throws OccupiedCellException if new position is occupied by another unit
     */
    public void move(Cell position) throws ExceedDistanceException, OccupiedCellException {
        if (this.position != position) {
            if (position.getPosX() >= (this.position.getPosX() - characteristics.getTravelDistance()) &&
                    position.getPosX() <= (this.position.getPosX() + characteristics.getTravelDistance()) &&
                    position.getPosY() >= (this.position.getPosY() - characteristics.getTravelDistance()) &&
                    position.getPosY() <= (this.position.getPosY() + characteristics.getTravelDistance())) {

                position.setUnit(this);
                try {this.position.removeUnit(this);} catch (AccessDeniedException e) {}
                this.position = position;

            } else {
                throw new ExceedDistanceException();
            }
        }
    }

    public void attack(Unit target) throws ExceedDistanceException{
        if (target.isAlive()){
            Cell position = target.position;
            if (position.getPosX() >= (position.getPosX() - characteristics.getTravelDistance()) &&
                    position.getPosX() <= (position.getPosX() + characteristics.getRadiusOfAttack()) &&
                    position.getPosY() >= (position.getPosY() - characteristics.getRadiusOfAttack()) &&
                    position.getPosY() <= (position.getPosY() + characteristics.getRadiusOfAttack())) {
                target.attacked(characteristics.getDamage());
            } else {
                throw new ExceedDistanceException();
            }
        }
    }

    public void attacked(int damage){
        health -= damage;
        if (!isAlive()){
            try {position.removeUnit(this);} catch (AccessDeniedException e) {}
            position = null;
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
        return characteristics.getDamage();
    }


    public int getRadiusOfAttack() {
        return characteristics.getRadiusOfAttack();
    }


    public int getTravelDistance() {
        return characteristics.getTravelDistance();
    }

    public Cell getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Unit: id="+id+", health="+health+", damage="+characteristics.getDamage();
    }


    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                health,
                characteristics.getDamage(),
                characteristics.getRadiusOfAttack(),
                characteristics.getTravelDistance()
        );
    }


    @Override
    public boolean equals(Object obj) {
        return this == obj || (this.getClass() == obj.getClass() && this.id == ((Unit)obj).id);
    }
}
