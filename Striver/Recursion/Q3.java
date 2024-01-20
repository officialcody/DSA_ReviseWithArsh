/**
 * You are given an integer ‘n’.
 * Your task is to return an array containing integers from ‘n’ to ‘1’ (in decreasing order) without using loops.
 */
public class Solution {
    public static int[] printNos(int x) {
        int [] answer = new int[x];
        formArray(answer, 0, x);
        return answer;
    }

    public static void formArray(int [] arr, int curr, int n) {
        if(curr >= n) return;
        arr[curr] = n - curr;
        formArray(arr, ++curr, n);
    }
}