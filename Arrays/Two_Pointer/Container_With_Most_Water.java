package Arrays.Two_Pointer;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int maxArea = Integer.MIN_VALUE;

        while(left<right)
        {
            int length = Math.min(height[left], height[right]);
            int width = right-left;
            int area = length*width;
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right])
            {
                left++;
            }

            else{
                right--;
            }


        }

        return maxArea;

    }
}
