/**
 * QUES 2 -> Friends of Appropriate Ages (LEETCODE - 825)
 * 
 * Company - Walmart
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] ageCounts = new int[121];
        int friendReqCount = 0;
        for(int age : ages) {
            ageCounts[age]++;
        }
        
        for(int a=0; a<=120; a++) {
            for(int b=(int)(0.5*a)+7+1; b<=a; b++) {
                friendReqCount += ageCounts[a] * ageCounts[b];
                if(a==b) {
                    friendReqCount -= ageCounts[a];
                }
            }
        }
        return friendReqCount;
    }
}