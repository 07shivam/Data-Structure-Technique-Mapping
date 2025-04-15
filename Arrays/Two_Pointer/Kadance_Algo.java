package Arrays.Two_Pointer;

public class Kadance_Algo {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0];
        int maxSumSoFar = 0;

        int n = nums.length;

        int i = 0, j = 0;
        while (j < n) {
            maxSumSoFar += nums[j];
            maxSum = Math.max(maxSum, maxSumSoFar);

            if (maxSumSoFar < 0) // if max sum becomes negative, reset maxSumSoFar to 0, to make sure we include
                                 // -ve subarrays if we are getting max sum for that
            {
                maxSumSoFar = 0;
                j++;
                i = j;
            } else {
                j++;

            }

        }

        return maxSum;

    }
}
