package game.modal.entities.resources;

import game.exceptions.modal.entities.resources.ResourceTypeException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoldTest {

    private Gold gold = new Gold();

    @AfterEach
    void tearDown() {
        gold = new Gold();
    }

    @Test
    void addDifferentResources() {
        assertThrows(ResourceTypeException.class, ()->gold.add(new Wood(1)));
        assertThrows(ResourceTypeException.class, ()->gold.add(new Ore(1)));
    }

    @Test
    void addGold(){
        assertDoesNotThrow(
                ()->{
                    gold.add(new Gold(3));
                    assertEquals(3, gold.getValue());
                }
        );
    }

    @Test
    void subDifferentResources() {
        assertThrows(ResourceTypeException.class, ()->gold.sub(new Wood(1)));
        assertThrows(ResourceTypeException.class, ()->gold.sub(new Ore(1)));
    }

    @Test
    void subGold(){
        assertDoesNotThrow(
                ()->{
                    gold.sub(new Gold(3));
                    assertEquals(-3, gold.getValue());
                }
        );
    }

    @Test
    void toStr() {
        assertEquals(new Gold().toString(), gold.toString());
    }

    @Test
    void copy(){
        Gold tmp = new Gold();
        Gold copy = tmp.copy();
        assertEquals(copy, tmp);
        assertNotSame(copy, tmp);
    }
}