import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriestTest {

    @Mock
    private Ballot ballot;

    @Test
    public void testPriestWhenNoOneCompetingToBeRuler() {
        Priest priest = new Priest();
        assert priest.rulerDisplay() == "None";
        assert priest.rulerAlliesDisplay() == "None";
    }

    @Test
    public void testPriestConductsElectionsAndShowsSpaceHas3Allies() {
        Kingdom space = new Kingdom("space", "gorilla");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);
        Priest priest = new Priest(competingKingdoms);

        when(ballot.message()).thenReturn("panda", "", "mammoth", "owl", "", "");
        priest.conductElections(ballot);

        Assert.assertEquals("Allies for space: 3\n", priest.competitorsAlliesDisplay());
        Assert.assertEquals("space", priest.rulerDisplay());
        Assert.assertEquals("land, ice, air", priest.rulerAlliesDisplay());
    }

    @Test
    public void testPriestDecidesIceAsRulerIfItHasMaxAllies() {
        Kingdom ice = new Kingdom("ice", "mammoth");
        Kingdom air = new Kingdom("air", "owl");
        Kingdom space = new Kingdom("space", "gorilla");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(ice).add(space).add(air);
        Priest priest = new Priest(competingKingdoms);

        when(ballot.message()).thenReturn("panda", "", "", "", "dragon", "", "", "octopus", "", "", "", "", "","", "", "", "", "");
        priest.conductElections(ballot);

        Assert.assertEquals("Allies for ice: 2\nAllies for space: 1\nAllies for air: 0\n", priest.competitorsAlliesDisplay());
        Assert.assertEquals("ice", priest.rulerDisplay());
        Assert.assertEquals("land, fire", priest.rulerAlliesDisplay());
    }

    @Test
    public void testPriestDoesNotAllowAKingdomToSendMessageToItself() {
        Kingdom space = new Kingdom("space", "gorilla");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);
        Priest priest = new Priest(competingKingdoms);

        when(ballot.message()).thenReturn("panda", "", "", "", "dragon", "gorilla");
        priest.conductElections(ballot);

        Assert.assertEquals("Allies for space: 2\n", priest.competitorsAlliesDisplay());
        Assert.assertEquals("space", priest.rulerDisplay());
        Assert.assertEquals("land, fire", priest.rulerAlliesDisplay());
    }

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