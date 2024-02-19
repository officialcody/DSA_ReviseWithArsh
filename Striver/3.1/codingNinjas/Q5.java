import java.util.* ;
import java.io.*; 
/**
 * Left rotate the array by one
 * Link: https://www.codingninjas.com/studio/problems/left-rotate-an-array-by-one_5026278?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
 */
public class Solution {

    static int[] rotateArray(int[] arr, int n) {
        int first = arr[0];
        for(int i=0;i<n-1;i++) {
            arr[i] = arr[i+1];
        }
        arr[n-1] = first;
        return arr;
    }
}