import java.util.*;
public class Solution {
    public static int[] countFrequency(int n, int x, int []nums){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        int [] answer = new int[n];
        for(int i=0;i<n;i++) {
            answer[i] = map.getOrDefault(i+1, 0);
        }
        return answer;
    }
}