package Arrays.Sliding_Window;

public class Minimum_Swaps_to_Group_All_One_Together {
    public static int MinSwaps(int[] nums) {
        int totalOnes = 0;

        for(int num : nums)
        {
            if(num == 1)
            totalOnes++;
        }

        // Edge case: if there are 0 or all 1s, no swaps needed
        if (totalOnes <= 1) return 0;

        int [] circularNums = new int[2*nums.length];
        for (int i = 0; i < circularNums.length; i++) {
            circularNums[i] = nums[i % nums.length];
        }

        // Use sliding window of size totalOnes to find max number of 1s in any window
        int maxOnesInWindow = 0;
        int left = 0;
        int right =0;
        int currentOnes = 0;

        for (right = 0; right < circularNums.length; right++) {
            
            // ✅ FIXED: Maintain sliding window of size 'totalOnes'
            if (right - left + 1 > totalOnes) {
                if (circularNums[left] == 1)
                    currentOnes--;
                left++;
            }

            // ✅ Count 1s in current window
            if (circularNums[right] == 1)
                currentOnes++;

            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }

        return totalOnes-maxOnesInWindow;


    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};

        int result = MinSwaps(nums);

        System.out.println("Minimum Swaps Required: " + result);
    }
}
