
/*
 Video Link 1 : https://www.youtube.com/watch?v=QXum8HQd_l4


Quick Sort is a fast, divide-and-conquer sorting algorithm that picks an element as a pivot and partitions the array around the pivot,
such that all elements smaller than the pivot are moved to its left, and all elements greater than the pivot are moved to its right. 
The pivot is then recursively sorted, and the process is repeated on the left and right subarrays.

PARTITION ALGORITHM:

The logic is - we start from the leftmost element and keep
track of index of smaller (or equal to) elements as i.

While traversing, if we find a smaller element, we swap current
element with arr[i]. Otherwise we ignore current element.

ILLUSTRATION:
                        10, 80, 90, 40, 50, 70
                            /\ (partition about 70)
                          /   \
                10, 40, 50    90 80
(partition about 50)  /\         /\  (partition about 80)
                    /   \      /   \
                10, 40   {}   {}   90
                /\
              /   \ (partition about 40)
            10    {}

Size = 6
a[] = 10, 80, 90, 40, 50, 70

Pivot : 70
10 40 50 70 90 80 

Pivot : 50
10 40 50 70 90 80 

Pivot : 40
10 40 50 70 90 80 

Pivot : 80
10 40 50 70 80 90 

 */

 import java.util.Arrays;
 import java.util.Scanner;
 import Utility.PrintHelper;
import Utility.SwapHelper;
 
 public class QuickSort {
 
     // Main Logic of Recursive MergeSort
     private static void quickSort(int[] arr, int low, int high) {
        if(low < high)
        {
            int pivot_index = partition(arr, low, high); //getting the pivot index, where we have parition the arr according to pivot value.
            System.out.println("Pivot : " + arr[pivot_index]);
            PrintHelper.printArray(arr);

            quickSort(arr, low, pivot_index-1);
            quickSort(arr, pivot_index+1, high);
        }
    
     }

     private static void quickSort2(int[] arr) {
        if (arr.length > 1) {
            int pivot_index = partition(arr, 0, arr.length-1); //getting the pivot index, where we have parition the arr according to pivot value.

            int[] left = Arrays.copyOfRange(arr, 0, pivot_index);
            int[] right = Arrays.copyOfRange(arr, pivot_index+1, arr.length);

            System.out.print("left = ");
            PrintHelper.printArray(left);
            System.out.print("right = ");
            PrintHelper.printArray(right);

            quickSort2(left);
            quickSort2(right);

            mergeArray(arr, left, arr[pivot_index], right);

            System.out.print("merge = ");
            PrintHelper.printArray(arr);

        }
     }

     private static void mergeArray(int[] arr, int[] left, int pivot, int[] right) {
        int index = 0;
    
        // Copy left subarray
        for (int num : left) {
            arr[index++] = num;
        }
    
        // Place pivot in its correct position
        arr[index++] = pivot;
    
        // Copy right subarray
        for (int num : right) {
            arr[index++] = num;
        }
    }


 
     // Merge function to merge two sorted arrays into one
     private static int partition(int[] arr, int low, int high) {
        //select pivot : arround which we will partition the array
        int pivot = arr[high];
        int i = low-1; //ith element will create space for the element which will be smaller than pivot and swap it in it's position

        for(int j =low; j< high; j++)
        {
            if(arr[j] < pivot)
            {
                i++; //creating space for arr[j] element to swap
                SwapHelper.swapTwoElement(arr, i, j);
            }
        }
        i++;//finally creating space for arr[j] to swap with pivot 
        SwapHelper.swapTwoElement(arr, i, high);
        return i;
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
 
         quickSort(arr, 0, arr.length-1);
         quickSort2(arr);
         PrintHelper.printArray(arr);
         scanner.close();
     }
 }
 