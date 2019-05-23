package game.modal.statistics;

import game.modal.entities.buildings.Building;
import game.modal.entities.player.Player;
import game.modal.entities.resources.ResourceGroup;
import game.modal.entities.units.Unit;

import java.util.List;

public class PlayerStatistics {

    private Player player;
    private ResourceGroup balance;

    private int unitsCount = 0;
    private int buildingsCount = 0;


    public PlayerStatistics(Player player, List<Unit> allUnits, List<Building> allBuildings){

        this.player = player;
        this.balance = player.getBalance().copy();

        for (Unit unit: allUnits) {
            if (unit.getOwner().equals(player)){
                unitsCount++;
            }
        }

        for (Building building: allBuildings) {
            if (building.getOwner().equals(player)){
                buildingsCount++;
            }
        }
    }


    public Player getPlayer() {
        return player;
    }


    public ResourceGroup getBalance() {
        return balance;
    }


    public int getUnitsCount() {
        return unitsCount;
    }


    public int getBuildingsCount() {
        return buildingsCount;
    }
}
