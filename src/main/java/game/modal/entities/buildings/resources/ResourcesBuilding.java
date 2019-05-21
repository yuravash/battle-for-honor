package game.modal.entities.buildings.resources;


import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;

import game.modal.entities.battlefield.Cell;

import game.modal.entities.buildings.Building;
import game.modal.entities.player.Player;


public abstract class ResourcesBuilding extends Building {


    protected ResourcesBuilding(int health, Cell position, Player owner) throws OccupiedCellException{
        super(health, position, owner);
    }


    public abstract void generateResources();


    @Override
    public String toString() {
        return "ResourcesBuilding("+super.toString()+")";
    }
}
