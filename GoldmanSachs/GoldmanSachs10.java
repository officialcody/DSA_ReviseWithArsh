/**
 * QUES 10 -> K Divisible Elements Subarrays (LEETCODE - 2261)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;

        Set<Long> ways = new HashSet<Long>();
        for(int i=0;i<n;i++) {
            int count  = 0;
            long hashCode = 1;
            for(int j=i;j<n;j++) {
                hashCode = 199L * hashCode + nums[j];
                if(nums[j] % p == 0) {
                    count++;
                }
                if(count <= k) {
                    ways.add(hashCode);
                }
            }
        }
        return ways.size();
    }
}