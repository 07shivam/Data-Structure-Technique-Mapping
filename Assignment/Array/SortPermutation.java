/*Sort the permutation
Link : https://learning.heycoach.in/student/super---30-march-2024/performance/coding-assignments

You are given a number 'n' and an array whose elements are from 1 to n and are distinct. So for example if the value of n was 3 then the array 'a' can be [1,3,2] or [1,2,3] or any other permutation. In one operation you can do the following:

Select an index 'i' from 1 to n-2 where a[i]>a[i-1] and a[i]>a[i+1] then you can swap a[i] with a[i+1].

Determine of it is possible to sort the array in increasing order after any number of operations.

Sample Input - 1

5
5 4 3 2 1
Sample Output - 1

false
Explanation:

There is no a[i] which is greater than a[i+1] and a[i-1] and thus we cannot apply any operation on the array and it remains the same.
Sample Input - 2:

5
1 3 2 4 5
Sample Output - 2:

true
 */
package Assignment.Array;

public class SortPermutation {

    public static void main(String[] args) {

        // Read input size
        // System.out.print("Enter the size of the array: ");
        // int n = sc.nextInt();
        int[] arr = {4,3,2,1,5};
        int n = arr.length;
        if (canBeSorted(arr, n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        // Read array elements
        // System.out.println("Enter the array elements: ");
        // for (int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }

        // // Check if sorting is possible
        // if (canBeSorted(arr, n)) {
        //     System.out.println("YES");
        // } else {
        //     System.out.println("NO");
        // }

    }

    // Function to check if sorting is possible
    public static boolean canBeSorted(int[] arr, int n) {
        for (int i = 1; i < n - 2; i++) {
            while (i >= 1 && i < n - 1 && arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                i--;  // Move back to check previous element
            }
        }

        // Check if array is fully sorted
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Swap function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
