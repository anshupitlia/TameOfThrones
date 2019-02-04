import java.util.HashMap;

public class Utils {
    static HashMap<Character, Integer> charCountMap(String string) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        char[] charArray = string.toCharArray();
        for (char c : charArray) {
            char lowerChar = Character.toLowerCase(c);
            if (countMap.containsKey(lowerChar)) {
                countMap.put(lowerChar, countMap.get(lowerChar) + 1);
            }
            else {
                countMap.put(lowerChar, 1);
            }
        }
        return countMap;
    }
}
