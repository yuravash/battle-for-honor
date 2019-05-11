package game.modal.entities.battlefield;

import java.util.ArrayList;

public class Battlefield {
    private static Battlefield instance;

    private ArrayList<ArrayList<Cell>> cells = new ArrayList<>();
    private BattlefieldType type;
    private int size;

    public synchronized static Battlefield getInstance(BattlefieldType battlefieldType) {
        if (instance == null){
            instance = new Battlefield(battlefieldType);
        }
        return instance;
    }

    public static void reset(){
        instance = null;
    }

    private Battlefield(BattlefieldType battlefieldType) {

        type = battlefieldType;

        switch(battlefieldType){
            case SMALL:
                size = 8;
                break;
            case MEDIUM:
                size = 10;
                break;
            case BIG:
                size = 11;
                break;
        }

        for (int i = 1; i <= size; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int j = 1; j <= size; j++) {
                Cell cell = new Cell(i, j);
                row.add(cell);
            }
            cells.add(row);
        }
    }

    public Cell getCell(int posY, int posX){
        if (posY > 0 && posY <= size && posX > 0 && posX <= size){
            return cells.get(posY).get(posX);
        }
        return null;
    }
}