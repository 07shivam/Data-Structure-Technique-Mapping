package Utility;

import java.util.List;

public class PrintHelper {
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static <T> void printTType(T[] arr) {
        for (T num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static <T> void printListTType(List<T> list) {
        for (T num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
