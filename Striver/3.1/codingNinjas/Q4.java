import java.util.*;
public class Solution {
    public static int removeDuplicates(int[] arr,int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(arr[0]);
        int answerIndexArr = 1;
        for(int i=1;i<n;i++) {
            if(set.contains(arr[i])) {
                answerIndexArr++;
            } else {
                set.add(arr[i]);
                answerIndexArr++;
            }
        }
        return set.size();
    }
}