package Arrays.Two_Pointer;

import java.util.Arrays;
import java.util.Comparator;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        int[][] arr = new int[n][2]; // {value, original index}

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort based on the value
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int i = 0, j = n - 1;
        while (i < j) {
            int sum = arr[i][0] + arr[j][0];
            if (sum == target) {
                return new int[] { arr[i][1], arr[j][1] }; // return original indices
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[0];
    }
}
