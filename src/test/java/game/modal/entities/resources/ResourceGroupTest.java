package game.modal.entities.resources;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceGroupTest {

    private ResourceGroup resourceGroup = new ResourceGroup(
          new Ore(), new Gold(), new Wood()
    );

    @AfterEach
    void tearDown() {
        resourceGroup = new ResourceGroup(
                new Ore(), new Gold(), new Wood()
        );
    }

    @Test
    void getOre() {
        assertEquals(new Ore(), resourceGroup.getOre());
        assertNotEquals(new Ore(1), resourceGroup.getOre());
    }

    @Test
    void getGold() {
        assertEquals(new Gold(), resourceGroup.getGold());
        assertNotEquals(new Gold(1), resourceGroup.getGold());
    }

    @Test
    void getWood() {
        assertEquals(new Wood(), resourceGroup.getWood());
        assertNotEquals(new Wood(1), resourceGroup.getWood());
    }

    @Test
    void greater() {

        ResourceGroup tmp_1 = new ResourceGroup(
                new Ore(1), new Gold(1), new Wood(1)
        );

        ResourceGroup tmp_2 = new ResourceGroup(
                new Ore(0), new Gold(0), new Wood(0)
        );

        ResourceGroup tmp_3 = new ResourceGroup(
                new Ore(-1), new Gold(-1), new Wood(-1)
        );

        assertFalse(resourceGroup.greater(tmp_1));
        assertFalse(resourceGroup.greater(tmp_2));
        assertTrue(resourceGroup.greater(tmp_3));
    }

    @Test
    void less() {

        ResourceGroup tmp_1 = new ResourceGroup(
                new Ore(1), new Gold(1), new Wood(1)
        );

        ResourceGroup tmp_2 = new ResourceGroup(
                new Ore(0), new Gold(0), new Wood(0)
        );

        ResourceGroup tmp_3 = new ResourceGroup(
                new Ore(-1), new Gold(-1), new Wood(-1)
        );

        assertTrue(resourceGroup.less(tmp_1));
        assertFalse(resourceGroup.less(tmp_2));
        assertFalse(resourceGroup.less(tmp_3));
    }

    @Test
    void toStr() {

        assertEquals(
                new ResourceGroup(
                        new Ore(0), new Gold(0), new Wood(0)
                ).toString(),
                resourceGroup.toString()
        );

        assertNotEquals(
                new ResourceGroup(
                        new Ore(-1), new Gold(0), new Wood(1)
                ).toString(),
                resourceGroup.toString()
        );
    }

    @Test
    void equals() {

        assertEquals(
                new ResourceGroup(
                        new Ore(0), new Gold(0), new Wood(0)
                ),
                resourceGroup
        );

        assertNotEquals(
                new ResourceGroup(
                        new Ore(-1), new Gold(0), new Wood(1)
                ),
                resourceGroup
        );
    }

    @Test
    void hashCodeTest() {
        assertEquals(
                new ResourceGroup(
                        new Ore(0), new Gold(0), new Wood(0)
                ).hashCode(),
                resourceGroup.hashCode()
        );

        assertNotEquals(
                new ResourceGroup(
                        new Ore(-1), new Gold(0), new Wood(1)
                ).hashCode(),
                resourceGroup.hashCode()
        );
    }

    @Test
    void add() {
        ResourceGroup tmp = new ResourceGroup(
                new Ore(1), new Gold(1), new Wood(1)
        );
        assertEquals(tmp, resourceGroup.add(tmp));
    }

    @Test
    void sub() {
        ResourceGroup tmp = new ResourceGroup(
                new Ore(1), new Gold(1), new Wood(1)
        );
        assertEquals(tmp, tmp.sub(resourceGroup));
    }

    @Test
    void copy(){
        ResourceGroup tmp = new ResourceGroup(
                new Ore(1), new Gold(1), new Wood(1)
        );
        ResourceGroup copy = tmp.copy();
        assertEquals(copy, tmp);
        assertNotSame(copy, tmp);
    }
}