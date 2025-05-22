

// Video Link: https://www.youtube.com/watch?v=xcPFUCh0jT0

/*	Bubble Sort is the simplest sorting algorithm that works
    by repeatedly swapping the adjacent elements if they are
    in wrong order. 
    In this we generally find the biggest
    element and swap it with the last element.

    We can also implement the logic recursively.
    Recursive Bubble Sort has no performance advantages, but
    can be a good question to check one’s understanding of
    Bubble Sort and recursion.

    If we take a closer look at Bubble Sort algorithm, we can
    notice that in first pass, we move largest element to end
    (Assuming sorting in increasing order). In second pass,
    we move second largest element to second last position and so on.

    Recursive Implementation:
    a) Base Case: If array size is 1, return.
    b) Do One Pass of normal Bubble Sort.
       This pass fixes last element of current subarray.
    c) Recur for all elements except last of current subarray.

O(n^2) time complexity
*/

import java.util.Scanner;

import Utility.PrintHelper;
import Utility.SwapHelper;

public class BubbleSort {

    // Main logic of bubbleSort Sort
    private static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) // last element already sorted ho jayega 1st loop k baad
            {
                if (arr[j] > arr[j + 1]) {
                    SwapHelper.swapTwoElement(arr, j, j + 1);
                }
            }
        }

    }

    // Recursive Bubble Sort Logic
    private static void bubbleSort2(int arr[], int n) {
        if (n == 1)
            return; // Base Case

        for (int i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                // Passing the largest element to end
                SwapHelper.swapTwoElement(arr, i, i + 1);

        bubbleSort2(arr, n - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Size = ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("a[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        bubbleSort(arr);
        bubbleSort2(arr, arr.length);

        PrintHelper.printArray(arr);
        scanner.close();
    }
}
