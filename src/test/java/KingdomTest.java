import org.junit.Assert;
import org.junit.Test;

public class KingdomTest {
    @Test
    public void testAKingdomHasANameAndEmblem() {
        Kingdom space = new Kingdom("space", "gorilla");
        assert space.displayName() == "space";
    }

    @Test
    public void testKingdomWouldBeAnAllyIfMessageIsEmblemName() {
        Kingdom space = new Kingdom("space", "gorilla");
        assert space.isAlly("gorilla") == true;
    }

    @Test
    public void testKingdomWouldBeAnAllyIfMessageContainsEmblemName() {
        Kingdom air = new Kingdom("air", "owl");
        assert air.isAlly("o111w222l333") == true;
    }

    @Test
    public void testKingdomWouldNotBeAnAllyIfMessageDoesNotContainEmblemName() {
        Kingdom air = new Kingdom("air", "owl");
        assert air.isAlly("o111w222333") == false;
    }

    @Test
    public void testKingdomWouldBeAnAllyIfMessageContainDoubleEmblemName() {
        Kingdom air = new Kingdom("air", "owl");
        assert air.isAlly("owlowl") == true;
    }

    @Test
    public void testKingdomWouldBeAnAllyIfMessageContainEmblemNameInAnyCase() {
        Kingdom air = new Kingdom("air", "owl");
        assert air.isAlly("OWL") == true;
    }

    @Test
    public void testKingdomShouldNotAddAnAllyIfItAlreadyExistsAsAnAlly() {
        Kingdom air = new Kingdom("air", "owl");
        air.addAlly(new Kingdom("space", "gorilla"));
        Assert.assertEquals("space", air.displayAllies());
        air.addAlly(new Kingdom("space", "gorilla"));
        Assert.assertEquals("space", air.displayAllies());
    }
}
