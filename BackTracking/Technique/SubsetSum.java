package BackTracking.Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem : 
Given an array of positive integers nums and a target sum target, determine if any subset of nums can add up exactly to target.
If such a subset exists, return True; otherwise, return False.

Approach : 
Sort the array to make pruning easier. This way, we can stop early if the current subset sum plus the next element exceeds the target.

Use a recursive function to build subsets by including or excluding elements.

If the subset sum equals the target, we stop and return True.

If the sum exceeds the target or if all elements have been considered without reaching the target, backtrack and try a different combination.

 */
public class SubsetSum {
    public static boolean subsetSum(int[] nums, int target) {

        Arrays.sort(nums);

        int currentSum = 0;

        return createSubset(nums, 0, target, currentSum);
    }

    private static boolean createSubset(int[] nums, int i, int target, int currentSum) {

        if (i == nums.length) {
            return false;
        }

        if (currentSum == target) {
            return true;
        }

        if(createSubset(nums, i + 1, target, currentSum + nums[i]))
        {
            return true;
        }

        if(createSubset(nums, i + 1, target, currentSum))
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 7, 8, 10 };
        int target = 11;

        boolean result = subsetSum(nums, target);
        System.out.println("Is there a subset that sums to " + target + "? " + result);
    }

}
