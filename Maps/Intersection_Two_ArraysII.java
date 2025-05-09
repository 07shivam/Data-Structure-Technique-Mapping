package Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_Two_ArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequecyMap = new HashMap<>();

        for(int num : nums1)
        {
            frequecyMap.put(num, frequecyMap.getOrDefault(num, 0)+1);
        }

        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (frequecyMap.getOrDefault(num, 0) > 0) {
                result.add(num);
                frequecyMap.put(num, frequecyMap.get(num) - 1);
            }
        }

        // Convert List<Integer> to int[]
    int[] intersection = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
        intersection[i] = result.get(i);
    }

    return intersection;
    }
}
