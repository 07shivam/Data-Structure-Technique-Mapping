package Divide_And_Conquer;

public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        // return kadaneAlgo(nums);
        return maxSubArrayWithDNC(nums, 0, nums.length - 1);

    }

    private int maxSubArrayWithDNC(int[] nums, int left, int right) {

        if (left == right) // return last remaining element in the range
        {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int leftMaxSum = maxSubArrayWithDNC(nums, left, mid);
        int rightMaxSum = maxSubArrayWithDNC(nums, mid + 1, right);

        int maxMergeSum = mergeMaxSubarraySum(nums, left, mid, right);

        return Math.max(maxMergeSum, Math.max(leftMaxSum, rightMaxSum));

    }

    private int mergeMaxSubarraySum(int[] nums, int left, int mid, int right) {
        // TODO Auto-generated method stub

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        int maxSum = 0;
        for (int i = mid; i >= left; i--) {
            maxSum += nums[i];
            leftSum = Math.max(leftSum, maxSum);
        }
        // It should go from mid to left, not left to mid. This is because you're
        // calculating the maximum sum of subarrays ending at mid, and you want to move
        // leftward.

        maxSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            maxSum += nums[i];
            rightSum = Math.max(rightSum, maxSum);
        }

        return leftSum + rightSum;
    }

    public int kadaneAlgo(int[] nums) {
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
