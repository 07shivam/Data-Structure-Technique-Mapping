package Searching.MindMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int num : nums1) {
            s1.add(num);
        }

        for (int num : nums2) {
            if (s1.contains(num)) {
                s2.add(num); // ensures uniqueness
            }
        }

        int[] ans = new int[s2.size()];
        int index = 0;
        for (int val : s2) {
            ans[index++] = val;
        }

        return ans;

    }

}
