import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RulerTest {
    @Test
    public void testRulerHasANameAndAlliesKingdom() {
        Kingdom air = new Kingdom("Air", "Owl");
        Kingdom water = new Kingdom("Water", "Octopus");
        ArrayList<Kingdom> expectedAllies = new ArrayList<>();
        expectedAllies.add(air);
        expectedAllies.add(water);
        Pandemonium pandemonium =  new Pandemonium();
        pandemonium.addAlly(air);
        pandemonium.addAlly(water);

        Ruler ruler = new Ruler(pandemonium);

        assertEquals(ruler.displayName(), "Shan");
        assertEquals(ruler.displayAllies(), "Air, Water");
    }
}
