import java.util.ArrayList;
import java.util.Iterator;

public class Priest {
    private ArrayList<Kingdom> allKingdoms = new ArrayList<>();
    private CompetingKingdoms competingKingdoms;
    private Ruler ruler;
    public static final int WINNING_CRITERIA = 3;

    public Priest() {
        initKingdoms();
        this.competingKingdoms = new CompetingKingdoms();
        this.ruler = new Ruler();
    }

    public Priest(CompetingKingdoms competingKingdoms) {
        initKingdoms();
        this.competingKingdoms = competingKingdoms;
        this.ruler = new Ruler();
    }

    public String competitorsAlliesDisplay() {
        return competingKingdoms.alliesDisplay();
    }

    public String rulerDisplay() {
        return ruler.displayName();
    }

    public String rulerAlliesDisplay() {
        return ruler.displayAllies();
    }

    public void conductElections() {
        Iterator<Kingdom> iterator = competingKingdoms.iterator();
        while(iterator.hasNext()) {
            Kingdom competitorKingdom = iterator.next();
            for (Kingdom kingdom: allKingdoms) {
                competitorKingdom.sends(kingdom, new Ballot().message());
            }
        }
        ruler = new Ruler(competingKingdoms.rulingKingdom());
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
