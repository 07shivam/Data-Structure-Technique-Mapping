/*
 Link : https://leetcode.com/problems/move-zeroes/description/
 */
package Arrays.Two_Pointer;

import Core.SwapHelper;

public class Move_Zeros {
    public void moveZeroes(int[] nums) {
        //using quick sort or two pointer
        int pivot = 0;
        int i = -1;

        for(int j=0; j<nums.length; j++)
        {
            if(nums[j] != pivot)
            {
                i++;
                SwapHelper.swapTwoElement(nums, i, j);
            }
        }
    }
}
