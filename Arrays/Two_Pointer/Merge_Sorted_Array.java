package Arrays.Two_Pointer;

public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int newSize = m+n;
        int i =0;
        int j=0;
        int k =0;
        while(j < nums2.length)
        {

            if(nums1[i] <= nums2[j])
            {
                j++;
            }

            else{
                int temp =  nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;
                
            }

            k++;

        }

    }
}
