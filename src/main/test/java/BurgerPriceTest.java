import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerPriceTest extends BaseTestCase {

    private Bun bun;
    private Ingredient ingredient;
    private float expectedResult;

    public BurgerPriceTest(Bun bun, Ingredient ingredient, float expectedResult) {
        this.bun = bun;
        this.ingredient = ingredient;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {new Bun(null, 100), new Ingredient(null, null, 100), 300},
                {new Bun(null, 200), new Ingredient(null, null, 50), 450},
                {new Bun(null, 0), new Ingredient(null, null, 100), 100}
        };
    }

    @Test
    public void getPriceTest() {
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        assertEquals(expectedResult, burger.getPrice(), 0.1);
    }
}
