package game.modal.entities.resources;

import game.exceptions.modal.entities.resources.ResourceTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;


class WoodTest {

    private static int DEFAULT_VALUE = 100;

    private Wood woodWithZeroValue;
    private Wood woodWithNoZeroValue;


    @BeforeEach
    void setUp() {
        woodWithZeroValue = new Wood();
        woodWithNoZeroValue = new Wood(DEFAULT_VALUE);
    }

    @Test
    void addResourceWithSameType(){
        Resource resource = new Wood(5);

        assertDoesNotThrow(()->woodWithZeroValue.add(resource));
        assertEquals(5, woodWithZeroValue.getValue());
    }

    @Test
    void addResourceWithAnotherType() {
        Resource mockResource = Mockito.mock(Resource.class);
        Mockito.when(mockResource.getValue()).thenReturn(1);

        assertThrows(ResourceTypeException.class, ()->woodWithZeroValue.add(mockResource));
        assertEquals(0, woodWithZeroValue.getValue());
    }

    @Test
    void subResourceWithSameType(){
        Resource resource = new Wood(5);

        assertDoesNotThrow(()->woodWithNoZeroValue.sub(resource));
        assertEquals(DEFAULT_VALUE-5, woodWithNoZeroValue.getValue());
    }

    @Test
    void subResourceWithAnotherType() {
        Resource mockResource = Mockito.mock(Resource.class);
        Mockito.when(mockResource.getValue()).thenReturn(1);

        assertThrows(ResourceTypeException.class, ()->woodWithNoZeroValue.sub(mockResource));
        assertEquals(DEFAULT_VALUE, woodWithNoZeroValue.getValue());
    }

    @Test
    void toStr() {
        assertNotNull(woodWithZeroValue.toString());
    }

    @Test
    void copy() {
        Wood copiedInstance = woodWithNoZeroValue.copy();

        assertNotNull(copiedInstance);
        assertEquals(copiedInstance, woodWithNoZeroValue);
        assertNotSame(copiedInstance, woodWithNoZeroValue);
    }

    @Test
    void getValue() {
        assertEquals(0, woodWithZeroValue.getValue());
        assertEquals(DEFAULT_VALUE, woodWithNoZeroValue.getValue());
    }

    @Test
    void equalsResourceWithDifferentType() {
        Resource resource = Mockito.mock(Resource.class);
        Mockito.when(resource.getValue()).thenReturn(0);

        assertNotEquals(resource, woodWithZeroValue);
    }

    @Test
    void equalsResourceWithSameType() {
        Wood resource = new Wood();

        assertEquals(resource, woodWithZeroValue);
        assertNotEquals(resource, woodWithNoZeroValue);
    }

    @Test
    void hashCodeTest() {
        assertEquals(woodWithNoZeroValue.copy().hashCode(), woodWithNoZeroValue.hashCode());
        assertEquals(woodWithZeroValue.copy().hashCode(), woodWithZeroValue.hashCode());
    }
}