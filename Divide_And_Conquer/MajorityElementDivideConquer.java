package Divide_And_Conquer;

public class MajorityElementDivideConquer {

    public int majorityElement(int[] nums) {
        return majority(nums, 0, nums.length - 1);
    }

    private int majority(int[] nums, int lo, int hi) {
        // Base case: only one element
        if (lo == hi) return nums[lo];

        int mid = lo + (hi - lo) / 2;

        int leftMajor = majority(nums, lo, mid);
        int rightMajor = majority(nums, mid + 1, hi);

        // If both sides agree, that's the majority
        if (leftMajor == rightMajor) return leftMajor;

        // Otherwise, count each in the current range
        int leftCount = countInRange(nums, leftMajor, lo, hi);
        int rightCount = countInRange(nums, rightMajor, lo, hi);

        return leftCount > rightCount ? leftMajor : rightMajor;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MajorityElementDivideConquer solver = new MajorityElementDivideConquer();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + solver.majorityElement(nums)); // Output: 2
    }
}
