package BackTracking.Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
     public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        createSubset(nums, 0, res, subset);
        return res;
    }

    private void createSubset(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        createSubset(nums, index + 1, res, subset);

        subset.remove(subset.size() - 1);

        int idx = index+1;
        while(idx < nums.length && nums[index] == nums[idx])
        {
            idx++;
        }

        createSubset(nums, idx, res, subset);
    }
}
