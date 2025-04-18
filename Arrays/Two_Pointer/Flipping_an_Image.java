package Arrays.Two_Pointer;

import java.util.Arrays;

public class Flipping_an_Image {

    public static int[][] flipAndInvertImage(int[][] image) {

        for(int row =0; row< image.length ; row++)
        {
            image[row] = ReverseArray(image[row]);
            image[row] = InverseArray(image[row]);
        }

        return image;
        
    }

    public static int[][] flipAndInvertImageColWise(int[][] image) {

        for(int col =0; col< image[0].length ; col++)
        {
            int [] colArray = new int[image.length];

            for(int row = 0; row < image.length ; row++)
            {
                colArray[row] = image[row][col];
            }

            colArray = ReverseArray(colArray);
            colArray = InverseArray(colArray);

            for (int row = 0; row < image.length; row++) {
                image[row][col] = colArray[row];
            }
        }

        return image;
        
    }

    public static int[] ReverseArray(int[] arr) {
        int left = 0;
        int right = arr.length -1 ;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return arr;

    }

    public static int[] InverseArray(int[] arr) {
        int i = 0;
        int size = arr.length;

        while (i < size) {
         arr[i] =  arr[i] ^ 1;
         i++;
        }

        return arr;

    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 0},
            {1, 0, 1},
            {0, 0, 0}
        };

        int[][] result = flipAndInvertImage(image);

        System.out.println("Flipped and Inverted Image:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

        int[][] result2 = flipAndInvertImage(image);

        System.out.println("Flipped and Inverted Image ColWise:");
        for (int[] row : result2) {
            System.out.println(Arrays.toString(row));
        }
    }

}
