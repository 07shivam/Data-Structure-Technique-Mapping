package BackTracking.MindMap;

public class The_k_th_Lexicographical_String {
    
       int count;
    String result = "";

    public String getHappyString(int n, int k) {

        char[] chars = { 'a', 'b', 'c' };
        count = 0;
        getHappyStringBT(n, k, chars, new StringBuilder(), ' ');

        return result;
    }

    private void getHappyStringBT(int n, int k, char[] chars, StringBuilder tempStr, char prevChar) {
        // TODO Auto-generated method stub
        //base case
        if (tempStr.length() == n) {
            count++;
            if (count == k) {
                 result = tempStr.toString(); 
            }
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != prevChar) {
                tempStr.append(chars[i]);
                getHappyStringBT(n, k, chars, tempStr, chars[i]);
                tempStr.deleteCharAt(tempStr.length() - 1);
            }
        }

    }
}
