package game.modal.entities.resources;

import game.exceptions.modal.entities.resources.ResourceTypeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WoodTest {

    private Wood wood = new Wood();

    @AfterEach
    void tearDown() {
        wood = new Wood();
    }

    @Test
    void addDifferentResources() {
        assertThrows(ResourceTypeException.class, ()->wood.add(new Ore(1)));
        assertThrows(ResourceTypeException.class, ()->wood.add(new Gold(1)));
    }

    @Test
    void addWood(){
        assertDoesNotThrow(
                ()->{
                    wood.add(new Wood(3));
                    assertEquals(3, wood.getValue());
                }
        );
    }

    @Test
    void subDifferentResources() {
        assertThrows(ResourceTypeException.class, ()->wood.sub(new Ore(1)));
        assertThrows(ResourceTypeException.class, ()->wood.sub(new Gold(1)));
    }

    @Test
    void subGold(){
        assertDoesNotThrow(
                ()->{
                    wood.sub(new Wood(3));
                    assertEquals(-3, wood.getValue());
                }
        );
    }

    @Test
    void toStr() {
        assertEquals(new Wood().toString(), wood.toString());
    }

}