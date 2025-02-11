import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTests {

    private IngredientType expectedType = IngredientType.SAUCE;
    private String expectedName = "hot sauce";
    private float expectedPrice = 100f;
    private Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);

    @Test
    public void getPriceTest() {
        assertEquals(expectedPrice, ingredient.getPrice(), 0.01);
    }

    @Test
    public void getNameTest() {
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(expectedType, ingredient.getType());
    }
}
