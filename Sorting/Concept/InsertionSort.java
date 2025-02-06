// Video Link: https://www.youtube.com/watch?v=3GC83dh4cf0

/*
Insertion Sort is an elementary sorting algorithm that builds the final sorted array one item at a time.
It takes each element from the list and inserts it into its correct position in the already sorted part of the array.

Consider {12, 11, 13, 5, 6}

Loop for i = 1 (second element of the array) to 5 (size of the array)

i = 1 --> Since 11 is smaller than 12, move 12 and
          insert 11 before 12. {11, 12, 13, 5, 6}

i = 2 --> 13 will remain at its position as all elements
          in A[0...i-1] are smaller than 13. {11, 12, 13, 5, 6}

i = 3 --> 5 will move to the beginning and all other elements
          from 11 to 13 will move one position ahead of their
          current position. {5, 11, 12, 13, 6}

i = 4 --> 6 will move to position after 5, and elements from
          11 to 13 will move one position ahead of their
          current position. {5, 6, 11, 12, 13}


Again the above logic could be solved recursively:
    a) If array size is 1, return.
    b) Recur for (n-1) elements
    c) Insert last element at its correct position in sorted array

    function insertionSort(arr) {
         for (let i = 1; i < arr.length; i++) {
        // Store the current element
        let current = arr[i];
        let j = i - 1;

        // Shift elements of the sorted section to the right
        while (j >= 0 && arr[j] > current) {
            arr[j + 1] = arr[j];
            j--;
        }

        // Insert the current element at the correct position
        arr[j + 1] = current;
    }
}

O(n^2) time complexity
*/

import java.util.Scanner;
import Core.PrintHelper;

public class InsertionSort {

    // Main logic of Insertion Sort
    private static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) // assume 1st element is sorted, that is arr[0]
        {
            int current = arr[i];
            int j = i - 1;

            System.out.println("current" + current);
            System.out.println("outside : i : " + i + " j : "+ j);


            // Move elements of arr[0..i-1], that are
            // greater than key, to one position ahead
            // of their current position
            while (j >= 0 && arr[j] > current) {

                arr[j + 1] = arr[j];
                System.out.println("Inside : i : " + i + " j : "+ j);
                System.out.println("arr[j] : " + arr[j] + " current : "+ current);
                j--;
            }

            PrintHelper.printArray(arr);

            arr[j + 1] = current; // finally placing the current element in it's position
            System.out.println("finally placing the current element in it's position current" + current);
            PrintHelper.printArray(arr);

        }

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

        insertionSort(arr);
        PrintHelper.printArray(arr);
        scanner.close();
    }
}
