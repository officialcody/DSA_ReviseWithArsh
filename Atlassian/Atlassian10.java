/**
 * QUES 10 -> Maximum Non-Zero Product of Array Elements (LEETCODE - 1969)
 * 
 * Company - Atlassian
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    public int mod = 1_000_000_007;
    public int minNonZeroProduct(int p) {
        if(p == 1) return 1;

        long mx = (long)(Math.pow(2, p)) - 1;
        long sm = mx - 1;
        long n = sm/2;
        long sum = recursiveCall(sm, n);

        return (int)(sum * (mx % mod) % mod);
    }

    public long recursiveCall(long val, long n) {
        if(n == 0) return 1;
        if(n == 1) return (val % mod);

        long newVal = ((val % mod) * (val % mod)) % mod;

        if(n % 2 != 0) {
            return ((recursiveCall(newVal, n/2) % mod) * (val % mod)) % mod;
        }
        return recursiveCall(newVal, n/2) % mod;
    }
}