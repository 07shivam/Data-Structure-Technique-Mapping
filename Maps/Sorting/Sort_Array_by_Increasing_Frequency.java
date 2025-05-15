package Maps.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort_Array_by_Increasing_Frequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>();
        for (int num : nums) {
            keyList.add(num);
        }

        keyList.sort((a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // increasing frequency
            } else {
                return b - a; //otherwise sort them in decreasing order based on number in nums.
            }
        });

        // Build result array
        int[] result = new int[nums.length];
        for (int i = 0; i < keyList.size(); i++) {
            result[i] = keyList.get(i);
        }

        return result;
    }
}
