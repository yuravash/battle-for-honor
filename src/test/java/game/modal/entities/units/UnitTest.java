package game.modal.entities.units;

import game.exceptions.entities.battlefield.cell.OccupiedCellException;
import game.exceptions.entities.units.ExceedDistanceException;
import game.modal.entities.battlefield.Cell;

import game.modal.entities.units.humans.Archer;
import game.modal.entities.units.humans.Cavalry;
import game.modal.entities.units.humans.Knight;

import game.modal.entities.units.orcs.Berserk;
import game.modal.entities.units.orcs.Headhunter;
import game.modal.entities.units.orcs.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    Unit unit_1 = null;
    Unit unit_2 = null;
    Unit unit_3 = null;

    @BeforeEach
    void tearDown(){
        unit_1 = null;
        unit_2 = null;
        unit_3 = null;
    }

    @Test
    void init(){
        Cell tmp_cell_11 = new Cell(1,1);
        Cell tmp_cell_22 = new Cell(1, 2);
        Cell tmp_cell_33 = new Cell(3, 3);

        assertDoesNotThrow(() -> unit_1 = new Knight(tmp_cell_11));
        assertDoesNotThrow(() -> unit_2 = new Berserk(tmp_cell_22));
        assertDoesNotThrow(() -> unit_3 = new Headhunter(tmp_cell_33));
    }

    @Test
    void initAndThrowsOccupiedException(){
        Cell tmp_cell_11 = new Cell(1,1);

        assertDoesNotThrow(() -> unit_1 = new Knight(tmp_cell_11));
        assertThrows(OccupiedCellException.class, () -> unit_2 = new Rider(tmp_cell_11));
    }

    @Test
    void moveUnitToEmptyCell() {
        Cell tmp_cell_11 = new Cell(1,1);
        Cell tmp_cell_12 = new Cell(1, 2);
        Cell tmp_cell_33 = new Cell(3, 3);

        assertDoesNotThrow(() -> unit_1 = new Knight(tmp_cell_11));
        assertEquals(tmp_cell_11, unit_1.getPosition());
        assertTrue(tmp_cell_11.haveUnit());

        assertDoesNotThrow(() -> unit_1.move(tmp_cell_12));
        assertEquals(tmp_cell_12, unit_1.getPosition());
        assertFalse(tmp_cell_11.haveUnit());
        assertTrue(tmp_cell_12.haveUnit());

        assertDoesNotThrow(() -> unit_2 = new Cavalry(tmp_cell_11));
        assertEquals(tmp_cell_11, unit_2.getPosition());
        assertTrue(tmp_cell_11.haveUnit());

        assertDoesNotThrow(() -> unit_2.move(tmp_cell_33));
        assertEquals(tmp_cell_33, unit_2.getPosition());
        assertFalse(tmp_cell_11.haveUnit());
        assertTrue(tmp_cell_33.haveUnit());
    }

    @Test
    void moveUnitAndThrowExceedDistanceException() {
        Cell tmp_cell_11 = new Cell(1,1);
        Cell tmp_cell_33 = new Cell(3, 3);

        assertDoesNotThrow(() -> unit_1 = new Knight(tmp_cell_11));
        assertEquals(tmp_cell_11, unit_1.getPosition());

        assertThrows(ExceedDistanceException.class, () -> unit_1.move(tmp_cell_33));
        assertEquals(tmp_cell_11, unit_1.getPosition());
    }

    @Test
    void moveUnitToOccupiedCell() {
        Cell tmp_cell_11 = new Cell(1,1);
        Cell tmp_cell_12 = new Cell(1, 2);

        assertDoesNotThrow(() -> unit_1 = new Knight(tmp_cell_11));
        assertEquals(tmp_cell_11, unit_1.getPosition());

        assertDoesNotThrow(() -> unit_2 = new Archer(tmp_cell_12));
        assertEquals(tmp_cell_12, unit_2.getPosition());

        assertThrows(OccupiedCellException.class, () -> unit_1.move(tmp_cell_12));
        assertEquals(tmp_cell_11, unit_1.getPosition());

        assertThrows(OccupiedCellException.class, () -> unit_2.move(tmp_cell_11));
        assertEquals(tmp_cell_12, unit_2.getPosition());
    }

    @Test
    void getLastId() {
        assertDoesNotThrow(() -> unit_1 = new Knight(new Cell(0,0)));
        assertEquals(Unit.getLastId(), unit_1.getId());
    }

    @Test
    void equals() {
        assertDoesNotThrow(() -> unit_1 = new Knight(new Cell(0,0)));
        assertDoesNotThrow(() -> unit_2 = new Cavalry(new Cell(0,0)));

        unit_3 = unit_1;

        assertEquals(unit_1, unit_3);
        assertNotEquals(unit_1, unit_2);
    }
}