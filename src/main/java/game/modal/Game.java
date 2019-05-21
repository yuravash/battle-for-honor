package game.modal;

import game.modal.entities.battlefield.Battlefield;
import game.modal.entities.battlefield.BattlefieldType;
import game.modal.entities.player.Player;
import game.modal.entities.units.RaceType;
import game.modal.entities.units.Unit;
import game.services.auth.user.User;

import java.util.ArrayList;

public class Game {

    private ArrayList<Unit> units = new ArrayList<>();

    private Player player1;
    private Player player2;

    Battlefield battlefield;

    public Game(User player1, RaceType player1Race, User player2, RaceType player2Race, BattlefieldType battlefieldType){
        this.player1 = new Player(player1, player1Race);
        this.player2 = new Player(player2, player2Race);
        battlefield = Battlefield.getInstance(battlefieldType);
    }

    public void endGame(){
        Battlefield.reset();
    }
}
