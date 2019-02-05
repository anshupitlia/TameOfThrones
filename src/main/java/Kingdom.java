import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Kingdom {
    private final String name;
    private final String emblem;
    private final ArrayList<Kingdom> allies;

    public Kingdom() {
        name = "None";
        emblem = "None";
        allies = new ArrayList<>();
    }

    public Kingdom(String name, String emblem) {
        this.name = name;
        this.emblem = emblem;
        this.allies = new ArrayList<>();
    }

    public void addAlly(Kingdom kingdom) {
        this.allies.add(kingdom);
    }

    public String displayName() {
        return name;
    }

    public String displayAllies() {
        if (allies.size() != 0)
          return allies.stream().map(Kingdom::displayName).collect(Collectors.joining(", "));
        else return "None";
    }

    public boolean isWinningRuler() {
          return allies.size() >= Priest.WINNING_CRITERIA;
    }

    public boolean isAlly(String message) {
        if (message == emblem)
          return true;
        else
        {
            HashMap<Character, Integer> messageCharCountMap = Utils.charCountMap(message);
            HashMap<Character, Integer> emblemCharCountMap = Utils.charCountMap(emblem);
            for(Map.Entry entry : emblemCharCountMap.entrySet()) {
                if (messageCharCountMap.getOrDefault(entry.getKey(), 0).intValue() < ((Integer) entry.getValue()).intValue()) {
                    return false;
                }
            }
        }
        return true;
    }
}
