package Divide_And_Conquer;

import java.util.Arrays;

import Core.PrintHelper;

/*
Youtube Link : https://www.youtube.com/watch?v=ynnWDBTdVi0&t=1205s

 Given an array arr[] of n integers, the goal is to count the number of inversions in the array. An inversion is a pair of indices (i, j) such that:

i < j
arr[i] > arr[j]

In other words, an inversion is when a larger number appears before a smaller number in the array.

Example:
For an array arr = [8, 4, 2, 1], the inversions are:

(0, 1) because 8 > 4
(0, 2) because 8 > 2
(0, 3) because 8 > 1
(1, 2) because 4 > 2
(1, 3) because 4 > 1
(2, 3) because 2 > 1
Total inversions = 6.

 */

public class Count_Inversions {

     public void inversionCount(int[] arr, int N) {


        int count = mergeSortAndCount(arr);

        System.out.println(count);
     }

     private int mergeSortAndCount(int[] arr) {
        // TODO Auto-generated method stub
        if(arr.length > 1)
        {
             int mid = arr.length / 2;

            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            int leftInversionCount = mergeSortAndCount(left);
            int rightInversionCount = mergeSortAndCount(right);
            int inversionCount = merge(arr, left, right);

            return leftInversionCount+ rightInversionCount+inversionCount;  


        }

        return 0;

     }

     private int merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        int inversionCount = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i];
                i++;
            } else {
                arr[k++] = right[j];
                j++;
                inversionCount += left.length - i; //mid-i+1
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

        return inversionCount;
    }

     public static void main(String[] args) {
        Count_Inversions solver = new Count_Inversions();

        int[] arr = {8, 4, 2, 1}; // Sample input
        int N = arr.length;

        solver.inversionCount(arr, N); // Should output 6
    }

}