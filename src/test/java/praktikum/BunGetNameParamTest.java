package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunGetNameParamTest {

    private final String name;

    public BunGetNameParamTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {""},
                {null},
                {"-120000000000000000000000000000f"},
                {"!@#$%^&*()vfdb "},
                {"     "},
                {"burger"}
        };
    }

    @Test
    public void getNameReturnsCorrectValue() {
        Bun bun = new Bun(name, 12f);
        assertEquals(name, bun.getName());
    }
}