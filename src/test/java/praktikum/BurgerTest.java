package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "sausage", 300);

    @Mock
    Ingredient ingredient;

    @Test
    public void testSetBun() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", 10f);
        burger.setBuns(bun);
        assertThat(burger.bun, is(notNullValue()));
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.removeIngredient(0);
        assertEquals((burger.ingredients.size()), 0);
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals((burger.ingredients.get(0).getName()), ingredient2.getName());
    }
}