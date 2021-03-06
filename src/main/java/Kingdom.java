import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Kingdom {
    private final String name;
    private final String emblem;
    private ArrayList<Kingdom> allies;
    private boolean isCompeting;
    private boolean allied;

    public Kingdom() {
        name = "None";
        emblem = "None";
        allies = new ArrayList<>();
        isCompeting = false;
    }

    public Kingdom(String name, String emblem) {
        this.name = name;
        this.emblem = emblem;
        this.allies = new ArrayList<>();
        this.isCompeting = false;
    }

    public void sends(Kingdom receiver, String msg) {
        if(receiver.isAlly(msg)) {
            this.addAlly(receiver);
        }
    }

    public void addAlly(Kingdom kingdom) {
        if (!this.allies.contains(kingdom)) {
            this.allies.add(kingdom);
        }
    }

    public String displayName() {
        return name;
    }

    public String displayAllies() {
        if (allies.size() != 0)
          return allies.stream().map(Kingdom::displayName).collect(Collectors.joining(", "));
        else return "None";
    }

    public boolean isAlly(String message) {
        if (this.allied) return false;
        if (this.isCompeting) return false;
        HashMap<Character, Integer> messageCharCountMap = Utils.charCountMap(message);
        HashMap<Character, Integer> emblemCharCountMap = Utils.charCountMap(emblem);
        for(Map.Entry entry : emblemCharCountMap.entrySet()) {
            if (messageCharCountMap.getOrDefault(entry.getKey(), 0).intValue() < ((Integer) entry.getValue()).intValue()) {
                return false;
            }
        }

        this.allied = true;
        return true;
    }

    public void markCompeting() {
        this.isCompeting = true;
    }

    public int allyCount() {
        return allies.size();
    }

    public void refreshAllegiance() {
        this.allies = new ArrayList<>();
        this.allied = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kingdom kingdom = (Kingdom) o;
        return Objects.equals(name, kingdom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
