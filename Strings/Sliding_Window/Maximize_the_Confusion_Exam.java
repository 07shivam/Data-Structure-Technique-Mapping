/*
The maxConsecutiveChar function tries to build the longest substring where you can flip at most k characters to the target character (ch).

It moves right to expand the window.

If flips exceed k, it moves left to shrink it.

The Math.max call compares max length achievable for both 'T' and 'F'.

 */
package Strings.Sliding_Window;

public class Maximize_the_Confusion_Exam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int maxT = maxConsecutiveAnswersHelper(answerKey, k, 'T');
        int maxF = maxConsecutiveAnswersHelper(answerKey, k, 'F');

        return Math.max(maxT, maxF);
    }

    public int maxConsecutiveAnswersHelper(String answerKey, int k, char ch)
    {
        int left=0, right =0;

        int maxLen = Integer.MIN_VALUE;

        int flipCount = 0;

        while(right < answerKey.length())
        {
            if(answerKey.charAt(right) == ch)
            {
                flipCount++;
            }

            while(flipCount > k)
            {
                if(answerKey.charAt(left) == ch)
                {
                    flipCount--;
                }

                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }

        return maxLen;
    }
}
