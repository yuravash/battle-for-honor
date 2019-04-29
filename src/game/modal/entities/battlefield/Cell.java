package game.modal.entities.battlefield;


import game.modal.entities.resources.Gold;
import game.modal.entities.resources.Ore;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.resources.Wood;

import java.util.Random;



public class Cell {

    private int posX;
    private int posY;

    private final ResourceGroup bonusResources = new ResourceGroup(
            new Ore(10*new Random().nextInt(3)),
            new Gold(10*new Random().nextInt(2)),
            new Wood(10*new Random().nextInt(3))
    );

    public Cell(int posY, int posX) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public String toString() {
        return "Cell(" +
                "posX=" + posX +
                ", posY=" + posY +
                ", bonusRessources=" + bonusResources +
                ')';
    }
}
