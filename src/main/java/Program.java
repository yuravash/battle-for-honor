/*
 * Strategy game
 * @author Yura Vashkiv
 */


import game.modal.entities.battlefield.Battlefield;
import game.modal.entities.battlefield.BattlefieldType;


public class Program {

    public static void main(String[] args){
        Battlefield.getInstance(BattlefieldType.SMALL);
    }

}