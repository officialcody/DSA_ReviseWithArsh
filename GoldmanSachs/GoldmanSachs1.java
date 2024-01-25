/**
 * QUES 1 -> Minimize the maximum of two arrays (LEETCODE - 2513)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    // Greatest Common Divisor
    long gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }

    // Least Common Multiple
    long calculateLCM(int a, int b) {
        return (long) ((a/gcd(a,b)) * b);
    }

    // Calculate the maximum element of both arrays after minimizing the possible solutions for number of ways
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long start = 1,end = (int)(2 * 1e9);
        long ans = end;
        long lcm = calculateLCM(divisor1, divisor2);
        while(start <= end){
            long mid = start + (end - start)/2;
            boolean a = (mid - mid / divisor1) >= uniqueCnt1;
            boolean b = (mid - mid / divisor2) >= uniqueCnt2;
            boolean c = (mid - mid / lcm) >= (uniqueCnt1 + uniqueCnt2);
            if(a && b && c) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int)ans;
    }
}