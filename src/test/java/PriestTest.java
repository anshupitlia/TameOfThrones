import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PriestTest {
    @Test
    public void testPriestTakesKingdomsCompetingToBeRuler() {
        Kingdom ice = new Kingdom("ice", "mammoth");
        Kingdom air = new Kingdom("air", "owl");
        Kingdom space = new Kingdom("space", "gorilla");

        CompetingKingdoms competingKingdoms = new CompetingKingdoms();
        competingKingdoms.add(ice).add(air).add(space);

        Priest universe = new Priest(competingKingdoms);
        assert universe.rulerDisplay() == "None";
        assert universe.alliesDisplay() == "None";
    }

    @Test
    public void testUniverseOfSoutherosDecidesShanAsRulerIfHeHasThreeAllies() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom ice = new Kingdom("ice", "mammoth");
        Kingdom air = new Kingdom("air", "owl");
        Priest universe = new Priest();

        universe.sends(air, "oaaawaaala");
        universe.sends(land, "a1d22n333a4444p");
        universe.sends(ice, "zmzmzmzaztzozh");

        universe.findRuler();

        assert universe.rulerDisplay() == "Shan";
        Assert.assertEquals(universe.alliesDisplay(), "air, land, ice");
    }

    @Test
    public void testUniverseOfSoutherosDecidesShanAsRulerIfHeHasLessThanThreeAllies() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom air = new Kingdom("air", "owl");
        Priest universe = new Priest();

        universe.sends(air, "oaaawaaala");
        universe.sends(land, "a1d22n333a4444p");

        universe.findRuler();

        assert universe.rulerDisplay() == "None";
        Assert.assertEquals(universe.alliesDisplay(), "None");
    }


    @Test
    public void testUniverseOfSoutherosDecidesShanAsRulerIfHeHasFourAllies() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom water = new Kingdom("water", "octopus");
        Kingdom ice = new Kingdom("ice", "mammoth");
        Kingdom air = new Kingdom("air", "owl");
        Kingdom fire = new Kingdom("fire", "dragon");
        Priest universe = new Priest();

        universe.sends(air, "Let’s swing the sword together");
        universe.sends(land, "Die or play the tame of thrones");
        universe.sends(ice, "Ahoy! Fight for me with men and money");
        universe.sends(water, "Summer is coming");
        universe.sends(fire, "Drag on Martin!");

        universe.findRuler();

        assert universe.rulerDisplay() == "Shan";
        Assert.assertEquals(universe.alliesDisplay(), "air, land, ice, fire");
    }
}