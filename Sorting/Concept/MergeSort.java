
/*
Merge Sort is a divide-and-conquer algorithm that divides the unsorted list into smaller sublists,
sorts them recursively, and then merges them back together to obtain a sorted list. It is known for its efficiency and stable sorting.

Divide:  Divide the list or array recursively into two halves until it can no more be divided. 
Conquer:  Each subarray is sorted individually using the merge sort algorithm. 
Merge:  The sorted subarrays are merged back together in sorted order. The process continues until all elements from both subarrays have been merged. 


Size = 5
a[] = 10, 6 , 1 , 99, 75

left = 10 6 
right = 1 99 75 

left = 10 
right = 6

merge = 6 10

left = 1
right = 99 75

left = 99
right = 75

merge = 75 99

merge = 1 75 99

merge = 1 6 10 75 99

 */

import java.util.Arrays;
import java.util.Scanner;
import Core.PrintHelper;

public class MergeSort {

    // Main Logic of Recursive MergeSort
    private static void mergeSort(int[] arr) {

        if (arr.length > 1) {
            int mid = arr.length / 2;

            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            System.out.print("left = ");
            PrintHelper.printArray(left);
            System.out.print("right = ");
            PrintHelper.printArray(right);

            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);

            System.out.print("merge = ");
            PrintHelper.printArray(arr);

        }

    }

    // Merge function to merge two sorted arrays into one
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i];
                i++;
            } else {
                arr[k++] = right[j];
                j++;
            }
        }

        // Copying remaining elements of left[] if any
        while (i < left.length) {
            arr[k++] = left[i];
            i++;
        }

        // Copying remaining elements of right[] if any
        while (j < right.length) {
            arr[k++] = right[j];
            j++;
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

        mergeSort(arr);
        PrintHelper.printArray(arr);
        scanner.close();
    }
}
