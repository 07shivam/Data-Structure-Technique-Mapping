package Assignment;

/*
 Mr. Yadav's Vacation
Rajesh Yadav is an English teacher at school who deceived the school into giving him 'n' days off from the school. Yadav wanted to go to Kerala with his daughters, so he wants to allocate several consecutive days to enjoy the holidays. Since he wants to make the best use of his time thus requiring careful preparation, he will only go for at least 'k' days.

You are given an array 'Weather' containing the weather forecast (i.e., temperature on the i-th day) in Kerala. Temperature is in degrees. Mr. Yadav was born in Himachal, so he can go on vacation only if the temperature does not rise above 't' degrees throughout his trip. He asks you to help him and count the number of ways to choose vacation dates in Kerala.

Input Format

The first line contains three integers ( n ), ( k ), and ( t ), representing the number of days, the minimum number of consecutive days for the vacation, and the maximum temperature Mr. Yadav can tolerate, respectively.
The second line contains ( n ) space-separated integers representing the temperatures on each day.
Output Format

Print the number of ways to choose vacation dates in Kerala.
Sample Input 1

3 1 15
-5 0 -10
Sample Output 1

6
Explanation

In this example, Mr. Yadav can go on these suitable dates: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3], which is equal to 6.

Sample Input 2

5 2 10
-5 0 5 10 15
Sample Output 2

6
 */
public class Mr_Yadav_Vacation {
    public static void solve(int weather[], int n, int k, int t) {
        // Write your code here;

        long totalWays = 0;
        int i = 0;

        while (i < n) {
            // Find valid segment of temps ≤ t
            if (weather[i] <= t) {
                int start = i;
                while (i < n && weather[i] <= t) {
                    i++;
                }
                int len = i - start;
                if (len >= k) {
                    int subLen = len - k + 1;
                    totalWays += (long) subLen * (subLen + 1) / 2;
                }
            } else {
                i++;
            }
        }

        System.out.println(totalWays);

    }
}
