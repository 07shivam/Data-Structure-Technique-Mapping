/*
 Link : https://leetcode.com/problems/minimum-size-subarray-sum/
 */
package Arrays.Sliding_Window;

public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int minSubArrayLength = Integer.MAX_VALUE;

        int l = 0, r = 0;

        while (r < nums.length) {
            currentSum += nums[r];

            while (currentSum >= target) {
                minSubArrayLength = Math.min(minSubArrayLength, r - l + 1);
                currentSum -= nums[l]; //Actually shrink the window by moving the left pointer rightward, excluding the leftmost element from the window.
                l++;
            }

            r++;
        }

        return (minSubArrayLength == Integer.MAX_VALUE) ? 0 : minSubArrayLength;

    }
}
