package Utility;

public class SwapHelper {

    // Auxiliary function to swap two elements
    public static void swapTwoElement(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
