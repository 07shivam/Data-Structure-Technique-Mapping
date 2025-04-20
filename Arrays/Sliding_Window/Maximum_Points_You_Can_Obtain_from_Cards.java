/*
 1.Initially calculate leftScore sum till kth index;
 2. Then, you start removing one card from the left side and adding one card from the right side in each iteration.
 3. Compare maxScore and return it
 */
package Arrays.Sliding_Window;

public class Maximum_Points_You_Can_Obtain_from_Cards {
    public int MaxScore(int[] cardPoints, int k) {
        
        int leftScore = 0;
        int rightScore = 0;
        for(int i=0; i<k;i++)
        {
            leftScore += cardPoints[i];
        }

        int maxScore = leftScore;
        int rightIndex = cardPoints.length -1;

        for(int j=k-1; j>=0 ; j--)
        {
            leftScore -= cardPoints[j];
            rightScore += cardPoints[rightIndex--];
            int totalScore = leftScore + rightScore;
            maxScore = Math.max(maxScore, totalScore);
        }


        return maxScore;
    }
}
