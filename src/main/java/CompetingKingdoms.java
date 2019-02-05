import java.util.ArrayList;
import java.util.Iterator;

public class CompetingKingdoms implements Iterable<Kingdom>{
    private ArrayList<Kingdom> competitors;

    @Override
    public Iterator<Kingdom> iterator() {
        return competitors.iterator();
    }

    public CompetingKingdoms() {
        this.competitors = new ArrayList<>();
    }

    public CompetingKingdoms add(Kingdom kingdom) {
        this.competitors.add(kingdom);
        kingdom.markCompeting();
        return this;
    }

    public Kingdom rulingKingdom() {
        if (this.competitors.get(0).isWinningRuler()) {
            return this.competitors.get(0);
        }
        return new Kingdom();
    }
}
