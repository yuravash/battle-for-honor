package game.modal;


import game.exceptions.modal.BuildingNotExistsException;
import game.exceptions.modal.entities.NotEnoughResourcesException;
import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.modal.entities.buildings.BuildingTypeException;
import game.exceptions.modal.factories.units.AccessDeniedException;
import game.exceptions.modal.factories.units.UnitTypeException;

import game.modal.entities.battlefield.Battlefield;
import game.modal.entities.battlefield.BattlefieldType;
import game.modal.entities.battlefield.Cell;

import game.modal.entities.buildings.Building;
import game.modal.entities.buildings.BuildingType;

import game.modal.entities.buildings.resources.Castle;
import game.modal.entities.buildings.resources.Mine;
import game.modal.entities.buildings.resources.ResourcesBuilding;
import game.modal.entities.buildings.resources.Sawmill;

import game.modal.entities.buildings.units.Barrack;
import game.modal.entities.buildings.units.UnitBuilding;

import game.modal.entities.player.Player;

import game.modal.entities.units.RaceType;
import game.modal.entities.units.Unit;
import game.modal.entities.units.UnitType;

import game.modal.statistics.MatchStatistics;

import game.services.auth.user.User;

import java.util.ArrayList;



public class Game {

    private ArrayList<Unit> units = new ArrayList<>();

    private Player player1;
    private Player player2;

    private Battlefield battlefield;

    private MatchStatistics matchStatistics;

    private ArrayList<Unit> allUnits = new ArrayList<>();
    private ArrayList<Building> allBuildings = new ArrayList<>();


    public Game(User player1, RaceType player1Race, User player2, RaceType player2Race, BattlefieldType battlefieldType){

        this.player1 = new Player(player1, player1Race);
        this.player2 = new Player(player2, player2Race);

        battlefield = Battlefield.getInstance(battlefieldType);

        matchStatistics = new MatchStatistics(this.player1, this.player2);
    }

    public void createUnit(int posX, int posY, UnitType unitType) throws IndexOutOfBoundsException, BuildingNotExistsException, OccupiedCellException, UnitTypeException, AccessDeniedException, NotEnoughResourcesException, BuildingTypeException {
        createUnit(this.player1, posX, posY, unitType);
    }

    private void createUnit(Player player, int posX, int posY, UnitType unitType) throws IndexOutOfBoundsException, BuildingNotExistsException, OccupiedCellException, UnitTypeException, AccessDeniedException, NotEnoughResourcesException, BuildingTypeException {

        Cell cell = battlefield.getCell(posY, posX);

        if (cell.haveBuilding()){

            Building building = cell.getBuilding();

            if (building instanceof UnitBuilding){
                allUnits.add(((UnitBuilding)building).createUnit(unitType, player));
            }
            else{
                throw new BuildingTypeException();
            }

        }
        else {
            throw new BuildingNotExistsException();
        }
    }


    public void createBuilding(int posX, int posY, BuildingType buildingType) throws IndexOutOfBoundsException, OccupiedCellException, NotEnoughResourcesException, BuildingTypeException{
        createBuilding(player1, posX, posY, buildingType);
    }


    private void createBuilding(Player player, int posX, int posY, BuildingType buildingType) throws IndexOutOfBoundsException, OccupiedCellException, NotEnoughResourcesException, BuildingTypeException{
        Cell cell = battlefield.getCell(posY, posX);

        Building building;

        switch (buildingType){
            case BARRACK:
                building = new Barrack(cell, player);
                break;
            case CASTLE:
                building = new Castle(cell, player);
                break;
            case MINE:
                building = new Mine(cell, player);
                break;
            case SAWMILL:
                building = new Sawmill(cell, player);
                break;
            default:
                throw new BuildingTypeException();
        }

        allBuildings.add(building);
    }


    public void nextRound(){

        for (Building current_buildings: allBuildings) {
            if (current_buildings instanceof ResourcesBuilding){
                ((ResourcesBuilding)current_buildings).generateResources();
            }
        }

        matchStatistics.newRound(allUnits, allBuildings);
    }
}
