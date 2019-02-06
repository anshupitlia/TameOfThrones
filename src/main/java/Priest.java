import java.util.ArrayList;
import java.util.Iterator;

public class Priest {
    private ArrayList<Kingdom> allKingdoms = new ArrayList<>();
    private CompetingKingdoms competingKingdoms;
    private Ruler ruler;
    private StringBuilder result;
    private int electionCount;

    public Priest(CompetingKingdoms competingKingdoms) {
        initKingdoms();
        this.competingKingdoms = competingKingdoms;
        this.ruler = new Ruler();
        this.electionCount = 0;
        this.result = new StringBuilder();
    }

    public String competitorsAlliesDisplay() {
        String roundInfo = String.format("Results after round %d ballot count\n", electionCount);
        StringBuilder intermediateResults = new StringBuilder();
        intermediateResults.append(roundInfo);
        intermediateResults.append(competingKingdoms.alliesDisplay());
        return intermediateResults.toString();
    }

    public String rulerDisplay() {
        return ruler.displayName();
    }

    public String rulerAlliesDisplay() {
        return ruler.displayAllies();
    }

    public void conductElections(Ballot ballot) {
        Iterator<Kingdom> iterator = competingKingdoms.iterator();
        this.electionCount++;
        while(iterator.hasNext()) {
            Kingdom competitorKingdom = iterator.next();
            for (Kingdom kingdom: allKingdoms) {
                if (!competitorKingdom.equals(kingdom))
                    competitorKingdom.sends(kingdom, ballot.message());
            }
        }
        findRulingKingdom(ballot);
    }

    public String displayResult() {
        return result.toString();
    }

    private void reconductElections(ArrayList<Kingdom> competingKingdoms, Ballot ballot) {
        this.allKingdoms.forEach(kingdom -> kingdom.refreshAllegiance());
        this.competingKingdoms = new CompetingKingdoms();
        competingKingdoms.forEach(kingdom -> {
            kingdom.refreshAllegiance();
            this.competingKingdoms.add(kingdom);
        });
        conductElections(ballot);
    }

    private void findRulingKingdom(Ballot ballot) {
        ArrayList<Kingdom> rulingKingdoms = competingKingdoms.rulingKingdoms();
        int totalRulingKingdoms = rulingKingdoms.size();
        if (totalRulingKingdoms == 1) {
            result.append(competitorsAlliesDisplay());
            ruler = new Ruler(rulingKingdoms.get(0));
        }
        if (totalRulingKingdoms > 1) {
            result.append(competitorsAlliesDisplay());
            reconductElections(rulingKingdoms, ballot);
        }
    }

    private void initKingdoms() {
        this.allKingdoms.add(new Kingdom("land", "panda"));
        this.allKingdoms.add(new Kingdom("water", "octopus"));
        this.allKingdoms.add(new Kingdom("ice", "mammoth"));
        this.allKingdoms.add(new Kingdom("air", "owl"));
        this.allKingdoms.add(new Kingdom("fire", "dragon"));
        this.allKingdoms.add(new Kingdom("space", "gorilla"));
    }
}
