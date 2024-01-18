class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long start = uniqueCnt1 + uniqueCnt2;
        long end = (int) 1e10;
        long lcm = lcm(divisor1, divisor2);
        long answer = 0;
        while(start <= end) {
            long mid = start + (end - start)/2;

            boolean a = (mid - mid/divisor1) >= uniqueCnt1;
            boolean b = (mid - mid/divisor2) >= uniqueCnt2;
            boolean c = (mid - mid/lcm) >= (uniqueCnt1 + uniqueCnt2);

            if(a && b && c) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int) answer;
    }

    public long lcm(int a, int b) {
        return (a * b)/gcd(a, b);
    }

    public long gcd(int a, int b) {
        if(a==0) return b;
        return gcd(b%a, a);
    }
}