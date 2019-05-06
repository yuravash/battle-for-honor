/*
 * Strategy game
 * @author Yura Vashkiv
 */


import game.modal.entities.battlefield.Battlefield;
import game.modal.entities.battlefield.BattlefieldType;
import game.modal.entities.units.Archer;
import game.modal.entities.units.Cavalry;
import game.modal.entities.units.Knight;

public class Game {

    public static void main(String[] args){
        Knight unit = new Knight();
        Archer unit2 = new Archer();
        Cavalry unit3 = new Cavalry();
        System.out.println(unit3);
        System.out.println(unit2);
        System.out.println(unit);

        Battlefield.getInstance(BattlefieldType.SMALL);
    }

}
