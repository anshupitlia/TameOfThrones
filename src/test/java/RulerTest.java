import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RulerTest {
    @Test
    public void testRulerHasANameAndAlliesKingdom() {
        Kingdom air = new Kingdom("Air");
        Kingdom water = new Kingdom("Water");

        ArrayList<Kingdom> expectedAllies = new ArrayList<>();
        expectedAllies.add(air);
        expectedAllies.add(water);

        Ruler ruler = new Ruler("Shan", expectedAllies);
        assertEquals(ruler.displayName(), "Shan");
        assertEquals(ruler.displayAllies(), "Air, Water");
    }
}
