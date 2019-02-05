import org.junit.Assert;
import org.junit.Test;

public class PriestTest {
    @Test
    public void testPriestWhenNoOneCompetingToBeRuler() {
        Priest priest = new Priest();
        assert priest.rulerDisplay() == "None";
        assert priest.alliesDisplay() == "None";
    }

    @Test
    public void testPriestDecidesSpaceAsRulerIfHeHasThreeAllies() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom ice = new Kingdom("ice", "mammoth");
        Kingdom air = new Kingdom("air", "owl");
        Kingdom space = new Kingdom("space", "gorilla");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);
        Priest priest = new Priest(competingKingdoms);

        priest.sends(space, air, "oaaawaaala");
        priest.sends(space, land, "a1d22n333a4444p");
        priest.sends(space, ice, "zmzmzmzaztzozh");
        priest.updateRuler();

        Assert.assertEquals("space", priest.rulerDisplay());
        Assert.assertEquals("air, land, ice", priest.alliesDisplay());
    }

    @Test
    public void testPriestDecidesNoneAsRulerIfHeHasLessThanThreeAllies() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom air = new Kingdom("air", "owl");
        Kingdom space = new Kingdom("space", "gorilla");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);
        Priest priest = new Priest(competingKingdoms);

        priest.sends(space, air, "oaaawaaala");
        priest.sends(space, land, "a1d22n333a4444p");
        priest.updateRuler();

        Assert.assertEquals("None", priest.rulerDisplay());
        Assert.assertEquals("None", priest.alliesDisplay());
    }


    @Test
    public void testPriestDecidesSpaceAsRulerIfHeHasFourAllies() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom space = new Kingdom("space", "gorilla");
        Kingdom water = new Kingdom("water", "octopus");
        Kingdom ice = new Kingdom("ice", "mammoth");
        Kingdom air = new Kingdom("air", "owl");
        Kingdom fire = new Kingdom("fire", "dragon");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);

        Priest priest = new Priest(competingKingdoms);

        priest.sends(space, air, "Let’s swing the sword together");
        priest.sends(space, land, "Die or play the tame of thrones");
        priest.sends(space, ice, "Ahoy! Fight for me with men and money");
        priest.sends(space, water, "Summer is coming");
        priest.sends(space, fire, "Drag on Martin!");

        priest.updateRuler();
        assert priest.rulerDisplay() == "space";
        Assert.assertEquals(priest.alliesDisplay(), "air, land, ice, fire");
    }
}