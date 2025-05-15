package Strings.Hashing;

import java.util.HashMap;
import java.util.Map;

public class Increasing_Decreasing_String {
    public String sortString(String s) {
        // Map to count the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();

        // Fill the map with character frequencies
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        // Continue until all characters are used
        while (freqMap.size() > 0) {
            // Step 1: Traverse from smallest to largest
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (freqMap.containsKey(ch)) {
                    result.append(ch);
                    freqMap.put(ch, freqMap.get(ch) - 1);
                    if (freqMap.get(ch) == 0) {
                        freqMap.remove(ch);
                    }
                }
            }

            // Step 2: Traverse from largest to smallest
            for (char ch = 'z'; ch >= 'a'; ch--) {
                if (freqMap.containsKey(ch)) {
                    result.append(ch);
                    freqMap.put(ch, freqMap.get(ch) - 1);
                    if (freqMap.get(ch) == 0) {
                        freqMap.remove(ch);
                    }
                }
            }
        }

        return result.toString();
    }
}
