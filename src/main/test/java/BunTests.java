import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {

    private String expectedName = "black bun";
    private float expectedPrice = 100f;
    private Bun bun = new Bun(expectedName, expectedPrice);

    @Test
    public void getNameTest() {
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(expectedPrice, bun.getPrice(), 0.01);
    }
}
