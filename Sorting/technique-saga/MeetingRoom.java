/*
 You are given an array of meeting time intervals, where each interval has a start and an end time [start, end].
Your task is to determine if a person can attend all meetings without any overlaps.
If any two meetings overlap, return false; otherwise, return true.

Example 1:

Copy
Input:
[[0,30],[5,10],[15,20]]
Output:
 false
Example 2:

Copy
Input:
 [[7,10],[2,4]]

Output:
 true

 sol : 
By first sorting the intervals by their start times, we can check for overlaps with a single pass through the array.
 Once sorted, any overlap will be evident if the start time of a meeting is earlier than the end time of the previous meeting.
 */

package Sorting.MindMap;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {
    public int start;
    int end;

    public MeetingRoom(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static int compaMeetingRoom(MeetingRoom m1, MeetingRoom m2) {
        return Integer.compare(m1.start, m2.start); // returns -1, 0, or 1
    }

    public static void main(String[] args) {
        List<MeetingRoom> intervals = new ArrayList<>();
        intervals.add(new MeetingRoom(3, 5));
        intervals.add(new MeetingRoom(1, 4));
        intervals.add(new MeetingRoom(2, 6));

        System.out.println("Before Sorting:");
        for (MeetingRoom interval : intervals) {
            System.out.println(interval.start + "  " + interval.end);
        }

        // Sorting based on start value
        // Collections.sort(intervals, Comparator.comparingInt(interval ->
        // interval.start));

        // intervals.sort(Comparator.comparingInt(i -> i.start));
        // intervals.sort(CustomSort::sortTwoArray);
        intervals.sort(MeetingRoom::compaMeetingRoom);

        System.out.println("\nAfter Sorting:");
        for (MeetingRoom interval : intervals) {
            System.out.println(interval.start + "  " + interval.end);
        }

        for (int i = 0; i < intervals.size() - 1; i++) {
            // Check if the current interval overlaps with the next one
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                System.out.println("false");
            }
        }
    }
}
