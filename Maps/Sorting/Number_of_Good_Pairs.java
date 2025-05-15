package Maps.Sorting;

import java.util.HashMap;
import java.util.Map;

/*
 Link : https://leetcode.com/problems/number-of-good-pairs/
 */
public class Number_of_Good_Pairs {
    public int numIdenticalPairs(int[] nums) {
        // Every time you see a number you've seen before, all previous occurrences can
        // pair with the current one.
        // So you increment the count by the frequency so far.
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            if (freq.containsKey(num)) {
                count += freq.get(num); // add the number of previous occurrences
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
