// Video Link 1: https://www.youtube.com/watch?v=pkkFqlG0Hds
// Video Link 2: https://www.youtube.com/watch?v=GUDLRan2DWM

/*

Selection Sort is a simple sorting algorithm that works by repeatedly finding theminimum 
element from the unsorted portion of the list and swapping it with the element at the beginning
of the sorted portion. This process continues until the entire list is sorted.

a) Find the minimum element of array from 0 to n-1 and swap it with 0th element.
b) Find the minimum element of array from 1 to n-1 and swap it with 1st element.
c) Find the minimum element of array from 2 to n-1 and swap it with 2nd element and so on.

function selectionSort(arr):
         for i from 0 to arr.length - 1:
        // Assume the first unsorted element is the minimum
        minIndex = i
        
        // Find the smallest element in the unsorted section
        for j from i + 1 to arr.length - 1:
            if arr[j] < arr[minIndex]:
                minIndex = j
        
        // Swap the found minimum element with the first unsorted element
        if minIndex != i:
            temp = arr[i]
            arr[i] = arr[minIndex]
            arr[minIndex] = temp
            
O(n^2) Time Complexity. */

import java.util.Scanner;
import Utility.PrintHelper;
import Utility.SwapHelper;

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
