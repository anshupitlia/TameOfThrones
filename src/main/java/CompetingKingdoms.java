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
//
//    public String competitorsAlliesDisplay() {
//        StringBuilder output = new StringBuilder();
//        Iterator<Kingdom> iterator = competingKingdoms.iterator();
//        while(iterator.hasNext()) {
//            Kingdom kingdom = iterator.next();
//            output.append("Allies for ");
//            output.append(kingdom.displayName());
//            output.append(": ");
//            output.append(kingdom.allyCount());
//            output.append("\n");
//        }
//        return output.toString();
//    }

    public String alliesDisplay() {
        StringBuilder output = new StringBuilder();
        competitors.forEach(kingdom -> {
            output.append("Allies for ");
            output.append(kingdom.displayName());
            output.append(": ");
            output.append(kingdom.allyCount());
            output.append("\n");
        });
        return output.toString();
    }
}
