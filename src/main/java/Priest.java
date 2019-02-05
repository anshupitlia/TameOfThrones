import java.util.ArrayList;

public class Priest {
    private ArrayList<Kingdom> allKingdoms = new ArrayList<>();
    private CompetingKingdoms competingKingdoms;
    private ARuler ruler;
    public static final int WINNING_CRITERIA = 3;

    public Priest() {
        this.allKingdoms.add(new Kingdom("land", "panda"));
        this.allKingdoms.add(new Kingdom("water", "octopus"));
        this.allKingdoms.add(new Kingdom("ice", "mammoth"));
        this.allKingdoms.add(new Kingdom("air", "owl"));
        this.allKingdoms.add(new Kingdom("fire", "dragon"));
        this.allKingdoms.add(new Kingdom("space", "gorilla"));
        this.competingKingdoms = new CompetingKingdoms();
        this.ruler = new Pandemonium();
    }

    public Priest(CompetingKingdoms competingKingdoms) {
        this.allKingdoms.add(new Kingdom("land", "panda"));
        this.allKingdoms.add(new Kingdom("water", "octopus"));
        this.allKingdoms.add(new Kingdom("ice", "mammoth"));
        this.allKingdoms.add(new Kingdom("air", "owl"));
        this.allKingdoms.add(new Kingdom("fire", "dragon"));
        this.allKingdoms.add(new Kingdom("space", "gorilla"));
        this.competingKingdoms = competingKingdoms;
        this.ruler = new Pandemonium();
    }

    public String rulerDisplay() {
        return ruler.displayName();
    }

    public String alliesDisplay() {
        return ruler.displayAllies();
    }

    public void sends(Kingdom receiver, String msg) {
        if(receiver.isAlly(msg)) {
            ruler.addAlly(receiver);
        }
    }

    public void findRuler() {
        if (ruler.isWinningRuler() && ruler instanceof Pandemonium) {
            ruler = new Ruler((Pandemonium) ruler);
        }
    }
}
