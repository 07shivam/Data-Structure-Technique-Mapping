package Arrays.Hashing;
/*
Link : https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/ 
1. HashMap for Frequency Count:
    Use a HashMap to store the frequency of each element in the array nums.
2.Pair Search:
    For each element i in the array, compute sum = k + i.
    If sum exists in the map, then the number of pairs for this element is the frequency of sum in the map. 
    Add that frequency to the result ans.
*/

import java.util.HashMap;
import java.util.Map;

public class Count_Number_of_Pairs_With_Absolute_DifferenceK {

    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num : nums)
        {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }
        int count =0;
        for(int num : nums)
        {
            int target = num+k;
            if(frequencyMap.containsKey(target))
            {
                count++;
               count += frequencyMap.get(target);
            }
        }

        return count;
    }
}
