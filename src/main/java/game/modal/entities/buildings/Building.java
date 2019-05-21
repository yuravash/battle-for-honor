package game.modal.entities.buildings;


import game.exceptions.modal.entities.battlefield.cell.AccessDeniedException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;

import game.modal.entities.battlefield.Cell;

import game.modal.entities.player.Player;

import java.util.Objects;



public abstract class Building {

    protected static int lastId = 0;


    protected int id;
    protected int health;

    protected Cell position;

    protected Player owner;


    protected Building(int health, Cell position, Player owner) throws OccupiedCellException {
        this.id = ++lastId;

        this.health = health;

        position.setBuilding(this);
        this.position = position;
        this.owner = owner;
    }


    public boolean isDestroyed(){
        return health <= 0;
    }

    public void attacked(int damage){
        health -= damage;
        if (isDestroyed()){
            try {position.removeBuilding(this);} catch (AccessDeniedException e) {}
            position = null;
        }
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


    public Cell getPosition() {
        return position;
    }


    public Player getOwner() {
        return owner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building)) return false;
        Building building = (Building) o;
        return id == building.id &&
                health == building.health &&
                position.equals(building.position) &&
                owner.equals(building.owner);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, health, position, owner);
    }


    @Override
    public String toString() {
        return "Building: " +
                "id=" + id +
                ", health=" + health +
                ", position=" + position +
                ", owner=" + owner;
    }
}
