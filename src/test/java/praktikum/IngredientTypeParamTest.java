package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {

    private final IngredientType ingredientType;

    public IngredientTypeParamTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}

        };
    }

    @Test
    public void testValue() {
        assertThat(ingredientType, is(notNullValue()));
    }


}