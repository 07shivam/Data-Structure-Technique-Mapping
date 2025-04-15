package Arrays.Two_Pointer;

public class MedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int i =0, j=0, counter =0;

        int k = n1+n2;

        int index2 = k/2;
        int index1 = (k-1)/2;

        int element1 = -1, element2 = -1;

        while(i<n1 && j<n2)
        {
            if(nums1[i] < nums2[j])
            {
                if(counter == index1) element1 = nums1[i];
                if(counter == index2) element2 = nums1[i];
                counter++;
                i++;
            }
            else
            {
                if(counter == index1) element1 = nums2[j];
                if(counter == index2) element2 = nums2[j];
                counter++;
                j++;
            }
        }

        while(i<n1)
        {
            if(counter == index1) element1 = nums1[i];
            if(counter == index2) element2 = nums1[i];
            counter++;
            i++;
        }

        while(j<n2)
        {
            if(counter == index1) element1 = nums2[j];
            if(counter == index2) element2 = nums2[j];
            counter++;
            j++;
        }

        if(k%2 ==1)
        {
            return index2;
        }

        return (double)(index1 + index2)/2.0;

    }
}
