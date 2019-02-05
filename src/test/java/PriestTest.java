import org.junit.Assert;
import org.junit.Test;

public class PriestTest {
    @Test
    public void testPriestWhenNoOneCompetingToBeRuler() {
        Priest priest = new Priest();
        assert priest.rulerDisplay() == "None";
        assert priest.rulerAlliesDisplay() == "None";
    }

    @Test
    public void testPriestConductsElectionsAndShowsSpaceHasNumberOfAllies() {
        Kingdom space = new Kingdom("space", "gorilla");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);
        Priest priest = new Priest(competingKingdoms);

        priest.conductElections();
        Assert.assertTrue(priest.competitorsAlliesDisplay().matches("Allies for space: \\d+\n"));
        Assert.assertEquals("space", priest.rulerDisplay());
        //Assert.assertEquals("air, land, ice", priest.rulerAlliesDisplay());
    }

//    @Test
//    public void testPriestDecidesNoneAsRulerIfHeHasLessThanThreeAllies() {
//        Kingdom land = new Kingdom("land", "panda");
//        Kingdom air = new Kingdom("air", "owl");
//        Kingdom space = new Kingdom("space", "gorilla");
//        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);
//        Priest priest = new Priest(competingKingdoms);
//
//        space.sends(air, "oaaawaaala");
//        space.sends(land, "a1d22n333a4444p");
//        priest.conductElections();
//
//        Assert.assertEquals("None", priest.rulerDisplay());
//        Assert.assertEquals("None", priest.rulerAlliesDisplay());
//    }
//
//
//    @Test
//    public void testPriestDecidesSpaceAsRulerIfHeHasFourAllies() {
//        Kingdom land = new Kingdom("land", "panda");
//        Kingdom space = new Kingdom("space", "gorilla");
//        Kingdom water = new Kingdom("water", "octopus");
//        Kingdom ice = new Kingdom("ice", "mammoth");
//        Kingdom air = new Kingdom("air", "owl");
//        Kingdom fire = new Kingdom("fire", "dragon");
//        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);
//
//        Priest priest = new Priest(competingKingdoms);
//
//        space.sends(air, "Let’s swing the sword together");
//        space.sends(land, "Die or play the tame of thrones");
//        space.sends(ice, "Ahoy! Fight for me with men and money");
//        space.sends(water, "Summer is coming");
//        space.sends(fire, "Drag on Martin!");
//
//        priest.conductElections();
//        assert priest.rulerDisplay() == "space";
//        Assert.assertEquals(priest.rulerAlliesDisplay(), "air, land, ice, fire");
//    }
//
//
//    @Test
//    public void testPriestDecidesNoneAsRulerIfSpaceHasThreeAlliesButOneOfThemIsCompeting() {
//        Kingdom land = new Kingdom("land", "panda");
//        Kingdom ice = new Kingdom("ice", "mammoth");
//        Kingdom air = new Kingdom("air", "owl");
//        Kingdom space = new Kingdom("space", "gorilla");
//        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space).add(air);
//        Priest priest = new Priest(competingKingdoms);
//
//        space.sends(air, "oaaawaaala");
//        space.sends(land, "a1d22n333a4444p");
//        space.sends(ice, "zmzmzmzaztzozh");
//        priest.conductElections();
//
//        Assert.assertEquals("None", priest.rulerDisplay());
//        Assert.assertEquals("None", priest.rulerAlliesDisplay());
//    }
}