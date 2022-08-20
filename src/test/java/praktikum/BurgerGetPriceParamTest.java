package praktikum;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;

        import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerGetPriceParamTest {

    private final float bunPrice;
    private final float ingredientPrice;
    private final float expected;

    public BurgerGetPriceParamTest(float bunPrice, float ingredientPrice, float expected) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {12f, 100f, 124f},
                {0, 100f, 100f},
                {12f, 0, 24f},
                {0, 0, 0}

        };
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        Bun bun = new Bun("black bun", bunPrice);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", ingredientPrice);
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        assertEquals(expected, burger.getPrice(), 0);
    }

}

