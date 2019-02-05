import java.util.ArrayList;

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

    public String rulerDisplay() {
        return ruler.displayName();
    }

    public String alliesDisplay() {
        return ruler.displayAllies();
    }

    public void updateRuler() {
        Kingdom rulingKingdom = competingKingdoms.rulingKingdom();
        ruler = new Ruler(rulingKingdom);
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
