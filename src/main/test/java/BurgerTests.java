import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests extends BaseTestCase {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);

        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void removeIngredientWrongIndexTest() {
        burger.addIngredient(ingredient);

        assertThrows(IndexOutOfBoundsException.class, () -> burger.removeIngredient(-1));
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredientOne = ingredient;
        Ingredient ingredientTwo = ingredient;

        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        burger.moveIngredient(0, 1);

        assertEquals(ingredientOne, burger.ingredients.get(1));
    }

    @Test
    public void moveIngredientWrongIndexTest() {
        burger.addIngredient(ingredient);

        assertThrows(IndexOutOfBoundsException.class, () -> burger.moveIngredient(0, 10));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(15f);

        assertEquals(215, burger.getPrice(), 0.01);

        Mockito.verify(ingredient, Mockito.times(1)).getPrice();
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(bun.getPrice()).thenReturn(15f);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);

        String expectedReceipt = String.format(
                "(==== %s ====)%n" + "= %s %s =%n" + "(==== %s ====)%n" + "%nPrice: %f%n",
                "black bun", "sauce", "hot sauce", "black bun", 15f * 2 + 10f);
        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }
}
