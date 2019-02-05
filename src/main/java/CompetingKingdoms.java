import java.util.ArrayList;

public class CompetingKingdoms {
    private ArrayList<Kingdom> competitors;

    public CompetingKingdoms() {
        this.competitors = new ArrayList<>();
    }

    public CompetingKingdoms add(Kingdom kingdom) {
        this.competitors.add(kingdom);
        return this;
    }

    public Kingdom rulingKingdom() {
        if (this.competitors.get(0).isWinningRuler()) {
            return this.competitors.get(0);
        }
        return new Kingdom();
    }
}
