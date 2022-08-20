package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DatabaseAvailableBunsParamTest {

    Database database = new Database();

    private final String name;
    private final float price;

    public DatabaseAvailableBunsParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Test
    public void getDatabaseAvailableBunsCorrectValue() {
        Bun expectedBun = new Bun(name, price);
        for (int i = 0; i < database.availableBuns().size(); i++) {
            if (expectedBun.getName().equals(database.availableBuns().get(i).getName())) {
                Assert.assertEquals(expectedBun.getName(), database.availableBuns().get(i).getName());
                Assert.assertEquals(expectedBun.getPrice(), database.availableBuns().get(i).getPrice(), 0.01F);
            }
        }
    }
}
