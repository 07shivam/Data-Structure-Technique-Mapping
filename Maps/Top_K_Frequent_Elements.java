package Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequecyMap = new HashMap<>();

        for(int num : nums)
        {
            frequecyMap.put(num, frequecyMap.getOrDefault(num, 0)+1);
        }

        List<Integer> keyList = new ArrayList<>(frequecyMap.keySet());
        keyList.sort((a,b) -> frequecyMap.get(a) - frequecyMap.get(b));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keyList.get(i);
        }
        
        return result;
        
    }
}
