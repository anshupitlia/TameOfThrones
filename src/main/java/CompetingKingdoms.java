import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

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

    public  ArrayList<Kingdom> rulingKingdoms() {
        ArrayList<Kingdom> kingdoms;
        int maxAllies = competitors.stream().max(comparing(intermediateKingdom -> intermediateKingdom.allyCount())).get().allyCount();
        kingdoms = (ArrayList<Kingdom>) competitors.stream().sorted(comparing(k -> k.allyCount())).filter(kingdom1 -> kingdom1.allyCount() == maxAllies).collect(Collectors.toList());
        return kingdoms;
    }

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
