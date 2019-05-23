package game.modal.statistics;

import game.modal.entities.buildings.Building;
import game.modal.entities.player.Player;
import game.modal.entities.units.Unit;

import java.util.List;


public class RoundStatistics {

    private int roundNumber;

    private PlayerStatistics player1Statistics;
    private PlayerStatistics player2Statistics;


    public RoundStatistics(int number, Player player1, Player player2, List<Unit> allUnits, List<Building> allBuildings){
        this.roundNumber = number;
        player1Statistics = new PlayerStatistics(player1, allUnits, allBuildings);
        player2Statistics = new PlayerStatistics(player2, allUnits, allBuildings);
    }


    public int getRoundNumber() {
        return roundNumber;
    }


    public PlayerStatistics getPlayer1Statistics() {
        return player1Statistics;
    }


    public PlayerStatistics getPlayer2Statistics() {
        return player2Statistics;
    }

}
