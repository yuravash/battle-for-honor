package game.modal.entities.resources;

import game.exceptions.entities.resources.ResourceTypeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OreTest {

    private Ore ore = new Ore();

    @AfterEach
    void tearDown() {
        ore = new Ore();
    }

    @Test
    void addDifferentResources() {
        assertThrows(ResourceTypeException.class, ()->ore.add(new Wood(1)));
        assertThrows(ResourceTypeException.class, ()->ore.add(new Gold(1)));
    }

    @Test
    void addGold(){
        assertDoesNotThrow(
                ()->{
                    ore.add(new Ore(3));
                    assertEquals(3, ore.getValue());
                }
        );
    }

    @Test
    void subDifferentResources() {
        assertThrows(ResourceTypeException.class, ()->ore.sub(new Wood(1)));
        assertThrows(ResourceTypeException.class, ()->ore.sub(new Gold(1)));
    }

    @Test
    void subOre(){
        assertDoesNotThrow(
                ()->{
                    ore.sub(new Ore(3));
                    assertEquals(-3, ore.getValue());
                }
        );
    }

    @Test
    void toStr() {
        assertEquals(new Ore().toString(), ore.toString());
    }
}