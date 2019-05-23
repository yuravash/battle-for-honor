package game.modal.statistics;

import game.modal.entities.buildings.Building;
import game.modal.entities.player.Player;
import game.modal.entities.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class MatchStatisticts {

    private int roundCount = 0;

    private Player player1;
    private Player player2;

    private List<RoundStatistics> rounds = new ArrayList<>();

    public MatchStatisticts(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void newRound(List<Unit> allUnits, List<Building> allBuildings){
        rounds.add(new RoundStatistics(++roundCount, player1, player2, allUnits, allBuildings));
    }

    public List<RoundStatistics> getRounds() {
        return rounds;
    }

}
