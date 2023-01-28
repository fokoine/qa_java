import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int kittensCount;
    private final String animalKind;
    private final boolean isCountRight;

    public FelineTest(int kittensCount, String animalKind, boolean isCountRight) {
        this.kittensCount = kittensCount;
        this.animalKind = animalKind;
        this.isCountRight = isCountRight;
    }

    @Parameterized.Parameters
    public static Object[][] testParams() {
        return new Object[][]{
                {2, "Хищник", false},
                {5, "Хищник", true},
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

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