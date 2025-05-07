/*
Link : https://leetcode.com/problems/longest-consecutive-sequence/

Approach : 
1.add all values in set
2.iterate over the arrays
2.1. check if it is not 1st element, by checking i-1 element is present or not
if it present, skip it
2.2 if not, it is 1st element in longest sequest, use set to check if i+1 element present in it.
2.3 count++, while it is there
2.4 check the longest consective and update, if it is
return it
 */
package Maps;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestConsecutiveSequence = 0;
        int streak;

        for (int num : set) {
            // check if n-1 element is not there and skip it
            if (!set.contains(num - 1)) {
                int currentNo = num;
                streak = 1;

                while (set.contains(currentNo + 1)) {
                    streak++;
                    currentNo++;
                }
                longestConsecutiveSequence = Math.max(longestConsecutiveSequence, streak);
            }
        }

        return longestConsecutiveSequence;
    }
}
