import org.junit.Assert;
import org.junit.Test;

public class CompetingKingdomsTest {
    @Test
    public void testManyKingdomsCanBeCompetingRulersAndDisplayTheirAlliesSize() {
        Kingdom space = new Kingdom("space", "gorilla");
        space.addAlly(new Kingdom());
        space.addAlly(new Kingdom());
        CompetingKingdoms competingKingdoms = new CompetingKingdoms();
        Kingdom air = new Kingdom("air", "owl");
        air.addAlly(new Kingdom());
        competingKingdoms.add(space).add(air);

        Assert.assertEquals("Allies for space: 2\nAllies for air: 1\n", competingKingdoms.alliesDisplay());
    }
}
