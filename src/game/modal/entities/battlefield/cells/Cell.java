package game.modal.battlefield.cells;


public abstract class Cell {

    private int posX;
    private int posY;

    protected Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
