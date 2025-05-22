/*Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 */



/*Solution :
 * Step-by-Step Code Explanation
1. Cloning and Sorting the Array
java
Copy
Edit
int n = nums.length;
int[] result = nums.clone();
Arrays.sort(result);
result is a copy of the original nums array.
We sort result, so it is in ascending order.
Now, each index i in result represents the count of numbers smaller than result[i].
2. Creating a HashMap to Store First Occurrence
java
Copy
Edit
HashMap<Integer, Integer> map = new HashMap<>();

for(int i = 0; i < result.length; i++)
{
    map.putIfAbsent(result[i], i);
}
We use a HashMap map to store the first occurrence of each unique number in the sorted array.
The key is the number, and the value is the first index where it appears in the sorted array.
Why putIfAbsent()?
putIfAbsent(result[i], i) ensures we only store the first occurrence of each number.
If the number already exists in the map, we do not overwrite it.
This is important because duplicate numbers should have the same count of smaller numbers.
Example of map After Sorting [1,2,2,3,8]
perl
Copy
Edit
{
    1 → 0,
    2 → 1,  // First occurrence of 2 at index 1
    3 → 3,
    8 → 4
}
map.get(2) = 1 means there is 1 number smaller than 2.
map.get(3) = 3 means there are 3 numbers smaller than 3.
 */

package Sorting.MindMap;
import Utility.PrintHelper;

 
 public class SmallerNumberUsingQuickSort {
 
     // Main Logic of Recursive MergeSort
     public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int[] temp = nums.clone(); // Clone to prevent modification
            int pivotIndex = partition(temp, nums[i]); // Partition around nums[i]
            result[i] = pivotIndex; // Pivot index gives count of smaller elements
        }
        return result;
    }

    // Partition function to find count of elements smaller than pivot
    private static int partition(int[] arr, int pivot) {
        int count = 0;
        for (int num : arr) {
            if (num < pivot) {
                count++; // Count how many numbers are smaller than pivot
            }
        }
        return count; // Return count as pivot index
    }
 
     public static void main(String[] args) {
 
        //  Scanner scanner = new Scanner(System.in);
        //  System.out.print("Size = ");
        //  int size = scanner.nextInt();
 
         int[] arr = {8, 1, 2, 2, 3};
         //int[] arr = new int[] {8, 1, 2, 2, 3};


 
        //  for (int i = 0; i < size; i++) {
        //      System.out.print("a[" + i + "] = ");
        //      arr[i] = scanner.nextInt();
        //  }
        PrintHelper.printArray(smallerNumbersThanCurrent(arr));
         PrintHelper.printArray(arr);
         //scanner.close();
     }
 }
 