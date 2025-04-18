/*
 Link : https://leetcode.com/problems/maximum-average-subarray-i/submissions/1610447861/

 Apporach : 
 1.Calcute sum until kth index and assign maxSum;
 2.Calculate maxSum using sliding window, by starting with k+1 index to end of index
 3.Return maxSum/k;
 */

package Arrays.Sliding_Window;

public class Maximum_Average_Subarray {
    public double findMaxAverage(int[] nums, int k) {
        double sumSoFar = 0;
        int left = 0;
    
        for (int i = 0; i < k; i++) {
            sumSoFar += nums[i];
        }
    
        double maxSum = sumSoFar;
    
        for (int right = k; right < nums.length; right++) {
            sumSoFar += nums[right] - nums[left]; //sling window technique, moving the window
            maxSum = Math.max(sumSoFar, maxSum);
            left++;
        }
    
        return maxSum / k;
    }
}
