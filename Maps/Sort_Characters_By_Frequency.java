package Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 1. Create a frequency map using map
 2. sort the key of the frequncy map and put that in a list
 3. now iterate and create a new string using string builder 
 */
public class Sort_Characters_By_Frequency {
    public String frequencySort(String s) {
        Map<Character, Integer> frequecyMap = new HashMap<>();
        for(char ch : s.toCharArray())
        {
            frequecyMap.put(ch, frequecyMap.getOrDefault(ch, 0)+1);
        }

        List<Character> keyList = new ArrayList<>(frequecyMap.keySet());

        //sort in descending order of their frequency.
        keyList.sort((a,b) -> frequecyMap.get(b) - frequecyMap.get(a));
        
    }
}
