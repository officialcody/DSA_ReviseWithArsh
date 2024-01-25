/**
 * QUES 3 -> Minimum moves to equal array elements (LEETCODE - 462)
 * 
 * Company - Microsoft
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    // Approach 1 -> Finding Median and calculating the sum of Distance of each element from the median
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = 0;
        if(n%2 == 0) {
            median = (nums[n/2] + nums[(n-1)/2]) / 2;
        } else {
            median = nums[n/2];
        }
        int minimumMovesRequired = 0;
        for(int i=0;i<n;i++) {
            minimumMovesRequired += Math.abs(median - nums[i]);
        }
        return minimumMovesRequired;
    }
}