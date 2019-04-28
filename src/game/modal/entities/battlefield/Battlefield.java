package game.modal.entities.battlefield;

public class Battlefield {
    private static Battlefield instance;

    public synchronized static Battlefield getInstance() {
        if (instance == null){
            instance = new Battlefield();
        }
        return instance;
    }

    private Battlefield() {
    }
}