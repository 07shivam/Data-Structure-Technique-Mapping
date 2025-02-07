package Core;

import Sorting.Technique_Saga.MeetingRoom1;

public class CustomSort {
    public static <T extends MeetingRoom1> int sortTwoArray(T a, T b) {
        return Integer.compare(a.start, b.start);
    }

    public static int compareStringArray(String m1, String m2) {
        return (m2 + m1).compareTo(m1 + m2); // Sort in descending order
        // return (m1 + m2).compareTo(m2 + m1); // Sort in acending order
    }
}
