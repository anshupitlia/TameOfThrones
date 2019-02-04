import java.util.HashMap;

public class Utils {
    static HashMap<Character, Integer> charCountMap(String string) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        char[] charArray = string.toCharArray();
        for (char c : charArray) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            }
            else {
                countMap.put(c, 1);
            }
        }
        return countMap;
    }
}
