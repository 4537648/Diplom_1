package praktikum;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;

        import java.util.List;

        import static org.hamcrest.CoreMatchers.equalTo;
        import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParamTest {

    private final String bunName;
    private final String ingredientName;
    private final IngredientType ingredientType;
    private final float bunPrice;
    private final float ingredientPrice;
    private final float expected;

    public BurgerGetReceiptParamTest(String bunName, String ingredientName, IngredientType ingredientType, float bunPrice, float ingredientPrice, float expected) {
        this.bunName = bunName;
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"", "cutlet", IngredientType.SAUCE, 124f, 5f, 124f * 2 + 5f},
                {"white bun", "", IngredientType.FILLING, 4f, 500f, 4f * 2 + 500f},
                {"black bun", "sour cream", IngredientType.SAUCE, 124f, 500f, 124f * 2 + 500f},
                {null, "hot sauce", IngredientType.FILLING, 124f, 500f, 124f * 2 + 500f},
                {"red bun", null, IngredientType.SAUCE, 50f, 500f, 50f * 2 + 500f},
                {"white bun", "dinosaur", IngredientType.FILLING, 0f, 0f, 0f * 2 + 0f}

        };
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.bun = new Bun(bunName, bunPrice);
        burger.ingredients = List.of(new Ingredient(ingredientType, ingredientName, ingredientPrice));
        assertThat(burger.getReceipt(),
                equalTo(String.format("(==== %s ====)%n", bunName) +
                        String.format("= %s %s =%n", ingredientType.toString().toLowerCase(), ingredientName) +
                        String.format("(==== %s ====)%n", bunName) +
                        String.format("%nPrice: %f%n", expected)));
    }
}