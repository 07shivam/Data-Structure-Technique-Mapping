// Video Link 1: https://www.youtube.com/watch?v=pkkFqlG0Hds
// Video Link 2: https://www.youtube.com/watch?v=GUDLRan2DWM

/*

Selection Sort is a simple sorting algorithm that works by repeatedly finding theminimum 
element from the unsorted portion of the list and swapping it with the element at the beginning
of the sorted portion. This process continues until the entire list is sorted.

a) Find the minimum element of array from 0 to n-1 and swap it with 0th element.
b) Find the minimum element of array from 1 to n-1 and swap it with 1st element.
c) Find the minimum element of array from 2 to n-1 and swap it with 2nd element and so on.

O(n^2) Time Complexity. */

import java.util.Scanner;
import Core.PrintHelper;
import Core.SwapHelper;

public class SelectionSort {
    
    // Main logic of Selection Sort
    private static void selectionSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i< n; i++)
        {
            for(int j = i+1; j<n; j++)
            {
                if(arr[j] < arr[i])
                {
                    SwapHelper.swapTwoElement(arr, i, j);
                }
            }
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

        selectionSort(arr);
        PrintHelper.printArray(arr);
        scanner.close();
    }
}
