package Arrays.Two_Pointer;

import java.util.Arrays;

public class Squares_Sorted_Array {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] result = new int[n];
        int pos = n - 1;
    
        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
    
            if (leftSq > rightSq) {
                result[pos--] = leftSq;
                left++;
            } else {
                result[pos--] = rightSq;
                right--;
            }
        }
    
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] nums2 = {-5,-3,-2,-1};
        int[] result = sortedSquares(nums2);
        System.out.println("Sorted squares: " + Arrays.toString(result));
    }
}
