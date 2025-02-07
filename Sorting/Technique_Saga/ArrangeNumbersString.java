package Sorting.Technique_Saga;

import java.util.ArrayList;
import java.util.Collections;

import Core.PrintHelper;

public class ArrangeNumbersString {
    public static int compareStringArray(String m1, String m2) {
        return (m2 + m1).compareTo(m1 + m2); // Sort in descending order
        // return (m1 + m2).compareTo(m2 + m1); // Sort in acending order
    }

    public static void arrangeNumbers(int[] arr) {
        // covert int to string of arrays.
        ArrayList<String> strArr = new ArrayList<String>();
        for (int element : arr) {
            strArr.add(Integer.toString(element));
        }

        // sort the str array with custom sort
        Collections.sort(strArr, ArrangeNumbersString::compareStringArray);
        //strArr.sort((m1, m2) -> (m1 + m2).compareTo(m2 + m1));

        PrintHelper.printListTType(strArr);
    }

    public static void main(String[] args) {

        int[] arr = { 9, 81, 17, 56, 28, 98 };
        System.out.println("Before Sorting:");
        PrintHelper.printArray(arr);

        arrangeNumbers(arr);

    }
}
