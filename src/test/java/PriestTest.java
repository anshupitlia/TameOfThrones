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
        Priest priest = new Priest(new CompetingKingdoms());
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

        Assert.assertEquals("Results after round 1 ballot count\nAllies for space: 3\n", priest.competitorsAlliesDisplay());
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

        when(ballot.message()).thenReturn("panda", "", "", "dragon", "", "", "octopus", "", "", "", "", "","", "", "");
        priest.conductElections(ballot);

        Assert.assertEquals("Results after round 1 ballot count\n" +
                "Allies for ice: 2\nAllies for space: 1\nAllies for air: 0\n", priest.competitorsAlliesDisplay());
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

        Assert.assertEquals("Results after round 1 ballot count\nAllies for space: 2\n", priest.competitorsAlliesDisplay());
        Assert.assertEquals("space", priest.rulerDisplay());
        Assert.assertEquals("land, fire", priest.rulerAlliesDisplay());
    }

    @Test
    public void testPriestReconductsElectionWhenThereIsATie() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom air = new Kingdom("air", "owl");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(land).add(air);
        Priest priest = new Priest(competingKingdoms);

        when(ballot.message()).thenReturn("octopus", "mammoth", "", "", "", "", "", "", "dragon", "gorilla", "octopus", "", "", "", "","", "", "", "dragon", "gorilla");
        priest.conductElections(ballot);
        Assert.assertEquals("Results after round 1 ballot count\n" +
                "Allies for land: 2\n" +
                "Allies for air: 2\n" +
                "Results after round 2 ballot count\n" +
                "Allies for land: 1\n" +
                "Allies for air: 2\n", priest.displayResult());
        Assert.assertEquals("air", priest.rulerDisplay());
        Assert.assertEquals("fire, space", priest.rulerAlliesDisplay());
    }

    @Test
    public void testPriestReconductsElectionWhenThereIsATieWithZeroAllies() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom air = new Kingdom("air", "owl");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(land).add(air);
        Priest priest = new Priest(competingKingdoms);

        when(ballot.message()).thenReturn("", "", "", "", "", "", "", "", "", "", "octopus", "", "", "", "","", "", "", "dragon", "gorilla");
        priest.conductElections(ballot);
        Assert.assertEquals("Results after round 1 ballot count\n" +
                "Allies for land: 0\n" +
                "Allies for air: 0\n" +
                "Results after round 2 ballot count\n" +
                "Allies for land: 1\n" +
                "Allies for air: 2\n", priest.displayResult());
        Assert.assertEquals("air", priest.rulerDisplay());
        Assert.assertEquals("fire, space", priest.rulerAlliesDisplay());
    }
}