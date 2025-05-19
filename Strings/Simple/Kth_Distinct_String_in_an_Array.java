package Strings.Simple;

import java.util.LinkedHashMap;
import java.util.Map;
/*
Link : https://leetcode.com/problems/kth-distinct-string-in-an-array/submissions/1638656526/

Better Approach Using Map (No Sorting)

1. Use a LinkedHashMap<String, Integer> to store frequencies (to maintain insertion order).

2. Traverse the map and pick the kth string with value == 1 (i.e., appears exactly once).
 */
public class Kth_Distinct_String_in_an_Array {
    public String kthDistinct(String[] arr, int k) {

        Map<String, Integer> freqMap = new LinkedHashMap<>();

        // Count frequencies while maintaining insertion order
        for (String s : arr) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        for(String key : freqMap.keySet())
        {
            if(freqMap.get(key) == 1)
            {
                k--;
                if(k == 0)
                {
                    return key;
                }
            }
        }

        return "";
    }
}
