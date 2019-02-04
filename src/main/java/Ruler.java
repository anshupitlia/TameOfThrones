import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ruler extends ARuler {
    private final String king;
    private final ArrayList<Kingdom> allies;

    public Ruler(String king, ArrayList<Kingdom> allies) {
        this.king = king;
        this.allies = allies;
    }

    public Ruler(Pandemonium pandemonium) {
        this.king = pandemonium.getKing();
        this.allies = pandemonium.getAllies();
    }

    public String displayName() {
        return king;
    }

    public String displayAllies() {
        return allies.stream().map(Kingdom::displayName).collect(Collectors.joining(", "));
    }

    public void addAlly(Kingdom kingdom) {
        this.allies.add(kingdom);
    }

    @Override
    public boolean isWinningRuler() {
        return allies.size() >= UniverseOfSoutheros.WINNING_CRITERIA;
    }

}
