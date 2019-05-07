package game.modal.entities.battlefield;


import game.exceptions.entities.battlefield.cell.AccessDeniedException;
import game.exceptions.entities.battlefield.cell.OccupiedCellException;
import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;
import game.modal.entities.units.Unit;

import java.util.Random;



public class Cell {

    private int posX;
    private int posY;

    private Unit unit = null;

    private final ResourceGroup bonusResources = new ResourceGroup(
            new Ore(10*new Random().nextInt(3)),
            new Gold(10*new Random().nextInt(2)),
            new Wood(10*new Random().nextInt(3))
    );


    public Cell(int posY, int posX) {
        this.posX = posX;
        this.posY = posY;
    }

    public boolean haveUnit(){
        return unit != null;
    }


    public int getPosX() {
        return posX;
    }


    public int getPosY() {
        return posY;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) throws OccupiedCellException{
        if (!haveUnit()) {
            this.unit = unit;
        }
        else if (this.unit != unit){
            throw new OccupiedCellException();
        }
    }

    public void removeUnit(Unit unit) throws AccessDeniedException {
        if (this.unit == unit){
            this.unit = null;
        }
        else {
            throw new AccessDeniedException();
        }
    }

    @Override
    public String toString() {
        return "Cell(" +
                "posX=" + posX +
                ", posY=" + posY +
                ", bonusResources=" + bonusResources +
                ')';
    }
}
