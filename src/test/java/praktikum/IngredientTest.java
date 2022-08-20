package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    @Mock
    Ingredient ingredient;

    @Test
    public void testGetPrice() {
        when(ingredient.getPrice()).thenReturn(100f);
        assertEquals(100f, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetName() {
        when(ingredient.getName()).thenReturn("котлета");
        assertEquals("котлета", ingredient.getName());
    }

    @Test
    public void testGetType() {
        when(ingredient.getType()).thenReturn(SAUCE);
        assertEquals(SAUCE, ingredient.getType());
    }
}