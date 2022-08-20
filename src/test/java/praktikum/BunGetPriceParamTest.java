package praktikum;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;

        import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunGetPriceParamTest {

    private final float price;

    public BunGetPriceParamTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {12f},
                {0},
                {-120000000000000000000000000000f},
                {900000000000000000000000000000f}
        };
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Bun bun = new Bun("one", price);
        assertEquals(price, bun.getPrice(), 0);
    }
}