package game.modal.entities.units.orcs;

import game.modal.entities.battlefield.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BerserkTest {

    private Berserk unit;
    private Cell cell = new Cell(1,1);

    @Test
    void toStr() {
        assertDoesNotThrow(() -> unit = new Berserk(cell));
        assertEquals(
                "Berserk(Unit: id="+unit.getId()+", health="+unit.getHealth()+", damage="+unit.getDamage()+")",
                unit.toString()
        );
    }
}