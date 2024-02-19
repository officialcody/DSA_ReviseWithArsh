import java.util.* ;
import java.io.*; 

public class Solution {
    public static int largestElement(int[] arr, int n) {
        int maximumElement = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            maximumElement = Math.max(maximumElement, arr[i]);
        }
        return maximumElement;
    }
}