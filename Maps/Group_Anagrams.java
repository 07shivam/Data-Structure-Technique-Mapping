package Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groupAnagramsMap = new HashMap<>();

        for (String word : strs) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if (!groupAnagramsMap.containsKey(key)) {
                List<String> newStr = new ArrayList<>();
                groupAnagramsMap.put(key, newStr);
            }

            groupAnagramsMap.get(key).add(word);

        }

        return new ArrayList<>(groupAnagramsMap.values());

    }
}
