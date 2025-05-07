package Maps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_All_Duplicates {
        public List<Integer> findDuplicates(int[] nums) {

            Set<Integer> frequecySet = new HashSet<>();
            List<Integer> result = new ArrayList<>();

            for(int i=0; i < nums.length; i++)
            {
                if(frequecySet.contains(nums[i]))
                {
                    result.add(nums[i]);
                }

                frequecySet.add(nums[i]);
            }

            return result;
            
        
    }
}
