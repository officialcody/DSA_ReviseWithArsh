/**
 * You are given an integer ‘n’.
 * Your task is determining the sum of the first ‘n’ natural numbers and returning it.
 */
public class Solution {
    public static long sumFirstN(long n) {
        if(n == 1) return 1;
        return (long)(n + sumFirstN(n - 1));
        // return (long) (n*(n+1)/2);
    }
}