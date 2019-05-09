package game.modal.entities.units.humans;

import game.modal.entities.battlefield.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    private Knight unit;
    private Cell cell = new Cell(1,1);

    @Test
    void toStr() {
        assertDoesNotThrow(() -> unit = new Knight(cell));
        assertEquals(
                "Knight(Unit: id="+unit.getId()+", health="+unit.getHealth()+", damage="+unit.getDamage()+")",
                unit.toString()
        );
    }
}