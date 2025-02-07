/*
Link : https://leetcode.com/problems/sort-colors/submissions/1532793383/ 

You are given an array containing only three types of elements: 0, 1, and 2, which represent colors (for example, red, white, and blue). The task is to sort the array in-place so that elements of the same type are adjacent, with colors in the order 0, 1, and 2.

For Example
arr = {0,2,1,2,0,0,1} , so your answer should be {0,0,0,1,1,2,2}


 The key thing to note here is that there are always going to be three kinds of elements 0, 1 and 2.
 If we somehow put 0s and 2s at their correct place 1 will be sorted automatically.
 Using a three-pointer approach,we can sort the array in a single pass. We use pointers low, mid, and high.
 The low pointer tracks the next position for a 0,mid scans the array, and high tracks the next position for a 2.

 */

package Sorting.Technique_Saga;

import java.util.Arrays;

public class SortColours {
     public static void sortColors(int[] colors) {
        int low = 0, mid = 0, high = colors.length - 1;

        while (mid <= high) {
            if (colors[mid] == 0) {
                System.out.println("colors[mid] == 0");

                swap(colors, low, mid);
                System.out.print("low postion : " + low);
                System.out.print(", mid postion : " + mid);
                System.out.print(", high postion : " + high);

                System.out.print(", mid value : " + colors[mid]);
                System.out.println();

                printArray(colors);

                low++;
                mid++;
            } else if (colors[mid] == 1) {
                System.out.println("colors[mid] == 1");

                System.out.print("low postion : " + low);
                System.out.print(", mid postion : " + mid);
                System.out.print(", high postion : " + high);                
                System.out.print(", mid value : " + colors[mid]);
                System.out.println();

                printArray(colors);

                mid++;
            } else { // colors[mid] == 2
                System.out.println("colors[mid] == 2");

                swap(colors, mid, high);
                System.out.print("low postion : " + low);
                System.out.print(", mid postion : " + mid);
                System.out.print(", high postion : " + high);               
                 System.out.print(", mid value : " + colors[mid]);
                 System.out.println();
                printArray(colors);

                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] colors = {0, 2, 1, 0, 0, 1, 2};
        System.out.println("Before Sorting:");
        printArray(colors);
        
        sortColors(colors);

        System.out.println("After Sorting:");
        printArray(colors);
    }
}
