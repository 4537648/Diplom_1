package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


/*
    private final IngredientType ingredientType;

    public IngredientTypeParamTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }
 */

@RunWith(Parameterized.class)
public class DatabaseAvailableIngredientsParamTest {

    Database database = new Database();

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public DatabaseAvailableIngredientsParamTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    @Test
    public void getDatabaseAvailableBunsCorrectValue() {
        Ingredient expectedIngredient = new Ingredient(ingredientType, name, price);
        for (int i = 0; i < database.availableIngredients().size(); i++) {
            if (expectedIngredient.getName().equals(database.availableIngredients().get(i).getName())) {
                Assert.assertEquals(expectedIngredient.getName(), database.availableIngredients().get(i).getName());
                Assert.assertEquals(expectedIngredient.getPrice(), database.availableIngredients().get(i).getPrice(), 0.01F);
            }
        }
    }
}
