public class Solution {
    public static int traffic(int n, int m, int []vehicle) {
        int ans = 0;
        int count = 0;
        int right = 0;
        for(int left = 0;left < n;left++) {
            while(right < n && count <= m) {
                if(vehicle[right] == 0) {
                    count++;
                    if(count > m) {
                        count--;
                        break;
                    }
                }
                right++;
            }
            ans = Math.max(ans, right-left);
            if(vehicle[left] == 0) {
                count--;
            }
        }
        return ans;
    }
}