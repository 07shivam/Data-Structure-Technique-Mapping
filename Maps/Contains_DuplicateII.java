package Maps;

import java.util.HashSet;
import java.util.Set;

public class Contains_DuplicateII {
    
     public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int left = 0;
        //maintain a window and check if dublicate no comes in that window, if it does, return true..otherwise keeping slding the window
        for (int right = 0; right < nums.length; right++) {
            if(right-left > k)
            {
                window.remove(nums[left]);
                left++;
            }

            if (window.contains(nums[right])) //is this values already present in our window, then return true
                return true;

                window.add(nums[right]);
        }

        return false;
    }

}
