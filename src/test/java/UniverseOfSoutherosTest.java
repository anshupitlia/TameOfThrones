import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class UniverseOfSoutherosTest {
    @Test
    public void testUniverseOfSoutherosContainsMultipleKingdomsWithNoRulerDisplayNoneRuler() {
        ArrayList<Kingdom> kingdoms = new ArrayList<>();
        kingdoms.add(new Kingdom("land", "panda"));
        kingdoms.add(new Kingdom("water", "octopus"));
        kingdoms.add(new Kingdom("ice", "mammoth"));
        kingdoms.add(new Kingdom("air", "owl"));
        kingdoms.add(new Kingdom("fire", "dragon"));
        kingdoms.add(new Kingdom("space", "gorilla"));

        UniverseOfSoutheros universe = new UniverseOfSoutheros(kingdoms);

        assert universe.rulerDisplay() == "None";
        assert universe.alliesDisplay() == "None";
    }

    @Test
    public void testUniverseOfSoutherosDecidesShanAsRulerIfHeHasThreeAllies() {
        ArrayList<Kingdom> kingdoms = new ArrayList<>();
        Kingdom land = new Kingdom("land", "panda");
        Kingdom water = new Kingdom("water", "octopus");
        Kingdom ice = new Kingdom("ice", "mammoth");
        Kingdom air = new Kingdom("air", "owl");
        Kingdom fire = new Kingdom("fire", "dragon");
        Kingdom space = new Kingdom("space", "gorilla");
        kingdoms.add(land);
        kingdoms.add(water);
        kingdoms.add(ice);
        kingdoms.add(air);
        kingdoms.add(fire);
        kingdoms.add(space);
        UniverseOfSoutheros universe = new UniverseOfSoutheros(kingdoms);

        universe.sends(air, "oaaawaaala");
        universe.sends(land, "a1d22n333a4444p");
        universe.sends(ice, "zmzmzmzaztzozh");

        universe.findRuler();

        assert universe.rulerDisplay() == "Shan";
        Assert.assertEquals(universe.alliesDisplay(), "air, land, ice");
    }

    @Test
    public void testUniverseOfSoutherosDecidesShanAsRulerIfHeHasLessThanThreeAllies() {
        ArrayList<Kingdom> kingdoms = new ArrayList<>();
        Kingdom land = new Kingdom("land", "panda");
        Kingdom water = new Kingdom("water", "octopus");
        Kingdom ice = new Kingdom("ice", "mammoth");
        Kingdom air = new Kingdom("air", "owl");
        Kingdom fire = new Kingdom("fire", "dragon");
        Kingdom space = new Kingdom("space", "gorilla");
        kingdoms.add(land);
        kingdoms.add(water);
        kingdoms.add(ice);
        kingdoms.add(air);
        kingdoms.add(fire);
        kingdoms.add(space);
        UniverseOfSoutheros universe = new UniverseOfSoutheros(kingdoms);

        universe.sends(air, "oaaawaaala");
        universe.sends(land, "a1d22n333a4444p");

        universe.findRuler();

        assert universe.rulerDisplay() == "None";
        Assert.assertEquals(universe.alliesDisplay(), "None");
    }
}