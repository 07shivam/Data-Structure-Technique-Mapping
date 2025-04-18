package Arrays.Sliding_Window;

import java.util.Arrays;

public class Minimum_Difference_K_Scores {
    
    public static int minimumDifference(int[] nums, int k) {

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int size = nums.length - k;
        
        for (int i = 0; i <= size; i++) {
            int diff =  nums[i+k-1] - nums[i] ;

            System.out.println( nums[i+k-1] + " - " + nums[i] + " = " + diff);

            if(diff < minDiff)
            {
                minDiff = diff;
            }

                       System.out.println( i + " - " + size);

        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums2 = {1,4,7,9};
        System.out.println("Ans " + minimumDifference(nums2, 2));

        // System.out.println("Sorted squares: " + Arrays.toString(result));
    }

}
