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
}
