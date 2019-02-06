import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ElectionTest {

    @Mock
    private Ballot ballot;

    @Test
    public void testElectionWhenNoOneCompetingToBeRuler() {
        Election election = new Election(new CompetingKingdoms());
        assert election.rulerDisplay() == "None";
        assert election.rulerAlliesDisplay() == "None";
    }

    @Test
    public void testElectionShowsSpaceHas3Allies() {
        Kingdom space = new Kingdom("space", "gorilla");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);
        Election election = new Election(competingKingdoms);

        when(ballot.message()).thenReturn("panda", "", "mammoth", "owl", "", "");
        election.conduct(ballot);

        Assert.assertEquals("Results after round 1 ballot count\nAllies for space: 3\n", election.resultDisplay());
        Assert.assertEquals("space", election.rulerDisplay());
        Assert.assertEquals("land, ice, air", election.rulerAlliesDisplay());
    }

    @Test
    public void testElectionDecidesIceAsRulerIfItHasMaxAllies() {
        Kingdom ice = new Kingdom("ice", "mammoth");
        Kingdom air = new Kingdom("air", "owl");
        Kingdom space = new Kingdom("space", "gorilla");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(ice).add(space).add(air);
        Election election = new Election(competingKingdoms);

        when(ballot.message()).thenReturn("panda", "", "", "dragon", "", "", "octopus", "", "", "", "", "","", "", "");
        election.conduct(ballot);

        Assert.assertEquals("Results after round 1 ballot count\n" +
                "Allies for ice: 2\nAllies for space: 1\nAllies for air: 0\n", election.resultDisplay());
        Assert.assertEquals("ice", election.rulerDisplay());
        Assert.assertEquals("land, fire", election.rulerAlliesDisplay());
    }

    @Test
    public void testElectionDoesNotAllowAKingdomToSendMessageToItself() {
        Kingdom space = new Kingdom("space", "gorilla");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(space);
        Election election = new Election(competingKingdoms);

        when(ballot.message()).thenReturn("panda", "", "", "", "dragon", "gorilla");
        election.conduct(ballot);

        Assert.assertEquals("Results after round 1 ballot count\nAllies for space: 2\n", election.resultDisplay());
        Assert.assertEquals("space", election.rulerDisplay());
        Assert.assertEquals("land, fire", election.rulerAlliesDisplay());
    }

    @Test
    public void testElectionIsReconductedWhenThereIsATie() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom air = new Kingdom("air", "owl");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(land).add(air);
        Election election = new Election(competingKingdoms);

        when(ballot.message()).thenReturn("octopus", "mammoth", "", "", "", "", "", "", "dragon", "gorilla", "octopus", "", "", "", "","", "", "", "dragon", "gorilla");
        election.conduct(ballot);
        Assert.assertEquals("Results after round 1 ballot count\n" +
                "Allies for land: 2\n" +
                "Allies for air: 2\n" +
                "Results after round 2 ballot count\n" +
                "Allies for land: 1\n" +
                "Allies for air: 2\n", election.resultDisplay());
        Assert.assertEquals("air", election.rulerDisplay());
        Assert.assertEquals("fire, space", election.rulerAlliesDisplay());
    }

    @Test
    public void testElectionIsReconductedWhenThereIsATieWithZeroAllies() {
        Kingdom land = new Kingdom("land", "panda");
        Kingdom air = new Kingdom("air", "owl");
        CompetingKingdoms competingKingdoms = new CompetingKingdoms().add(land).add(air);
        Election election = new Election(competingKingdoms);

        when(ballot.message()).thenReturn("", "", "", "", "", "", "", "", "", "", "octopus", "", "", "", "","", "", "", "dragon", "gorilla");
        election.conduct(ballot);
        Assert.assertEquals("Results after round 1 ballot count\n" +
                "Allies for land: 0\n" +
                "Allies for air: 0\n" +
                "Results after round 2 ballot count\n" +
                "Allies for land: 1\n" +
                "Allies for air: 2\n", election.resultDisplay());
        Assert.assertEquals("air", election.rulerDisplay());
        Assert.assertEquals("fire, space", election.rulerAlliesDisplay());
    }
}