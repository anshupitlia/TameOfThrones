import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RulerTest {
    @Test
    public void testRulerHasAKingdom() {
        Kingdom air = new Kingdom("Air", "Owl");
        Kingdom water = new Kingdom("Water", "Octopus");
        Kingdom space = new Kingdom("Space", "Gorilla");

        space.addAlly(air);
        space.addAlly(water);

        Ruler ruler = new Ruler(space);

        assertEquals(ruler.displayName(), "Space");
        assertEquals(ruler.displayAllies(), "Air, Water");
    }
}
