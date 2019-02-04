import org.junit.Test;

public class KingdomTest {
    @Test
    public void testAKingdomHasAName() {
        Kingdom space = new Kingdom("space");
        assert space.displayName() == "space";
    }
}
