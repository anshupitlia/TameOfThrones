import java.util.HashMap;
import java.util.Map;

public class Kingdom {
    private final String name;
    private final String emblem;

    public Kingdom(String name, String emblem) {
        this.name = name;
        this.emblem = emblem;
    }

    public String displayName() {
        return name;
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
