package Searching.MindMap;
import java.util.ArrayList;
import java.util.List;

public class Target_Indices {

     public List<Integer> targetIndices(int[] nums, int target) {

        List<Integer> ans = new ArrayList<Integer>();
        int start = 0;
        int end = nums.length -1;

        while(start<=end)
        {
            int mid = (start + end) / 2;
            if(nums[mid] == target)
            {
                ans.add(mid);
            }

            else if(nums[mid] > target)
            {
                end = mid -1;
            }

            else
            {
                start = mid+1;
            }
        }


        return ans;

    }
}
