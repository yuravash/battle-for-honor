package game.modal.factories.units;

import game.exceptions.modal.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.modal.factories.units.UnitTypeException;
import game.modal.entities.battlefield.Cell;
import game.modal.entities.units.Unit;
import game.modal.entities.units.UnitType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumansUnitFactoryTest {

    private UnitFactory unitFactory = new HumansUnitFactory();
    private Unit unit;

    @Test
    void getHumansUnit() {

        Cell cell_11 = new Cell(1,1);
        Cell cell_22 = new Cell(2,2);
        Cell cell_33 = new Cell(3,3);

        assertDoesNotThrow(() -> unit = unitFactory.getUnit(UnitType.KNIGHT, cell_11));
        assertDoesNotThrow(() -> unit = unitFactory.getUnit(UnitType.ARCHER, cell_22));
        assertDoesNotThrow(() -> unit = unitFactory.getUnit(UnitType.CAVALRY, cell_33));

    }

    @Test
    void getUnitWithInvalidType() {

        Cell cell_11 = new Cell(1,1);
        Cell cell_22 = new Cell(2,2);
        Cell cell_33 = new Cell(3,3);

        assertThrows(UnitTypeException.class, () -> unit = unitFactory.getUnit(UnitType.BERSERK, cell_11));
        assertThrows(UnitTypeException.class, () -> unit = unitFactory.getUnit(UnitType.HEADHUNTER, cell_22));
        assertThrows(UnitTypeException.class, () -> unit = unitFactory.getUnit(UnitType.RIDER, cell_33));

    }

    @Test
    void getUnitWithSameCell() {

        Cell cell_11 = new Cell(1,1);

        assertDoesNotThrow(() -> unit = unitFactory.getUnit(UnitType.KNIGHT, cell_11));
        assertThrows(OccupiedCellException.class, () -> unit = unitFactory.getUnit(UnitType.KNIGHT, cell_11));

    }
}