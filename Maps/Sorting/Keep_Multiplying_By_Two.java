package Maps.Sorting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 Link : https://leetcode.com/problems/keep-multiplying-found-values-by-two/
 
 */
public class Keep_Multiplying_By_Two {
        public int findFinalValue(int[] nums, int original) {
        
            Set<Integer> set = new HashSet<>();

            for( int num : nums)
            {
                set.add(num);
            }

            if(set.contains(original))
            {
                while(true)
                {
                    int target = 2*original;
                    if(!set.contains(target))
                    {
                        return target;
                    }
                    original = target;
                }
            }

            return original;

    }
}
