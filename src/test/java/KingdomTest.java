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
        Kingdom space = new Kingdom("air", "owl");
        assert space.isAlly("o111w222l333") == true;
    }

    @Test
    public void testKingdomWouldNotBeAnAllyIfMessageDoesNotContainEmblemName() {
        Kingdom space = new Kingdom("air", "owl");
        assert space.isAlly("o111w222333") == false;
    }
}
