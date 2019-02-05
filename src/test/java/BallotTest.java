import org.junit.Test;

import static org.junit.Assert.*;

public class BallotTest {
    @Test
    public void testMessageReturnsARandomMessage() {
        Ballot ballot = new Ballot();
        assertNotEquals(ballot.message(), ballot.message());
    }
}