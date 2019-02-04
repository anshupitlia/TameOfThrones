import org.junit.Test;

public class PandemoniumTest {
    @Test
    public void testPandemoniumHasNoRuler() {
        Pandemonium ruler = new Pandemonium();
        assert ruler.displayName() == "None";
    }
}
