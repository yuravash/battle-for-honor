package game.modal.entities.units.orcs;

import game.modal.entities.battlefield.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadhunterTest {

    private Headhunter unit;
    private Cell cell = new Cell(1,1);

    @Test
    void toStr() {
        assertDoesNotThrow(() -> unit = new Headhunter(cell));
        assertEquals(
                "Headhunter(Unit: id="+unit.getId()+", health="+unit.getHealth()+", damage="+unit.getDamage()+")",
                unit.toString()
        );
    }
}