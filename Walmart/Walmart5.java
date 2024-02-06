/**
 * QUES 5 -> Get Equal Substrings Within Budget (LEETCODE - 1208)
 * 
 * Company - Walmart
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int [] diff = new int[s.length()];
        for(int i=0;i<s.length();i++) {
            int sVal = s.charAt(i);
            int tVal = t.charAt(i);
            diff[i] = Math.abs(sVal - tVal);
        }

        int maximumLength = 0;
        int currentCost = 0;
        int start = 0;

        for(int end = 0; end < diff.length; ++end) {
            currentCost += diff[end];
            while(currentCost > maxCost) {
                currentCost -= diff[start];
                ++start;
            }
            maximumLength = Math.max(maximumLength, end - start + 1);
        }
        return maximumLength;
    }
}