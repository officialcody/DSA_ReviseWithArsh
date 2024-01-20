/**
 * You are given an integer ‘n’.
 * Your task is to return an array containing integers from 1 to ‘n’ (in increasing order) without using loops.
 */

public class Solution {
    public static int[] printNos(int x) {
        int [] answer = new int[x];
        formArray(answer, 1, x);
        return answer;
    }

    public static void formArray(int [] arr, int curr, int n) {
        if(curr > n) return;
        arr[curr-1] = curr;
        curr++;
        formArray(arr, curr, n);
    }
}