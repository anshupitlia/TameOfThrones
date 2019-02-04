import java.util.ArrayList;

public class Pandemonium extends ARuler {
    private ArrayList<Kingdom> allies;
    private String king;

    public Pandemonium() {
        allies = new ArrayList<>();
        king = "Shan";
    }

    public String getKing() {
        return king;
    }

    public ArrayList<Kingdom> getAllies() {
        return allies;
    }

    public String displayName() {
        return "None";
    }

    public String displayAllies() {
        return "None";
    }

    @Override
    public void addAlly(Kingdom receiver) {
        allies.add(receiver);
    }

    @Override
    public boolean isWinningRuler() {
        return allies.size() >= UniverseOfSoutheros.WINNING_CRITERIA;
    }
}
