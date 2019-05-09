package game.modal.entities.units.humans;

import game.modal.entities.battlefield.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CavalryTest {

    private Cavalry unit;
    private Cell cell = new Cell(1,1);

    @Test
    void toStr() {
        assertDoesNotThrow(() -> unit = new Cavalry(cell));
        assertEquals(
                "Cavalry(Unit: id="+unit.getId()+", health="+unit.getHealth()+", damage="+unit.getDamage()+")",
                unit.toString()
        );
    }
}