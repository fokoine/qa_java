import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int kittensCount;
    private final String animalKind;

    public FelineTest(int kittensCount, String animalKind) {
        this.kittensCount = kittensCount;
        this.animalKind = animalKind;
    }

    @Parameterized.Parameters
    public static Object[][] testParams() {
        return new Object[][]{
                {2, "Хищник", false},
                {5, "Хищник", true},
        };
    }
    @Test
    public void getFoodTypeTest() throws Exception {
        Feline feline = new Feline();
        assertEquals((feline.getFood("Хищник")), (feline.getFood(animalKind)));
    }

    @Test
    public void checkFelineFamilyForCats() {
        Feline feline = new Feline();
        assertEquals(feline.getFamily(), "Кошачьи");
    }

    @Test
    public void checkGetKittensOne() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void checkGetKittensMoreThanOne() {
        Feline feline = new Feline();
        int expected = feline.getKittens(kittensCount);
        assertTrue(expected > 1);
    }

}