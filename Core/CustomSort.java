package Core;

import Sorting.MindMap.MeetingRoom;

public class CustomSort {
    public static <T extends MeetingRoom> int sortTwoArray(T a, T b) {
        return Integer.compare(a.start, b.start);
    }
}
