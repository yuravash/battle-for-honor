package game.modal.entities.resources;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceTest {

    private Resource gold = new Gold();
    private Resource wood = new Wood();
    private Resource ore = new Ore();

    @AfterEach
    void tearDown() {
        gold = new Gold();
        wood = new Wood();
        ore = new Ore();
    }

    @Test
    void getValue() {
        assertEquals(0, gold.getValue());
        assertEquals(0, wood.getValue());
        assertEquals(0, ore.getValue());
    }

    @Test
    void equalsDifferentResources() {
        assertNotEquals(gold, wood);
        assertNotEquals(gold, ore);
        assertNotEquals(ore, wood);
    }

    @Test
    void equalsSameResource() {
        assertEquals(new Wood(), wood);
        assertEquals(new Ore(), ore);
        assertEquals(new Gold(), gold);
    }

    @Test
    void equalsWithDifferentValues() {
        assertNotEquals(new Wood(1), wood);
        assertNotEquals(new Ore(1), ore);
        assertNotEquals(new Gold(1), gold);
    }

    @Test
    void hashCodeTest() {
        assertEquals(new Gold().hashCode(), gold.hashCode());
        assertEquals(new Wood().hashCode(), wood.hashCode());
        assertEquals(new Ore().hashCode(), ore.hashCode());
    }
}