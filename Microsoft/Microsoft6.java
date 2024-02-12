/**
 * QUES 6 -> Count the Number of Incremovable Subarrays I (LEETCODE - 2970)
 * 
 * Company - Microsoft
 * 
 * #revisewitharsh
 * #6companies30dayschallenge
 */
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++)
                if (task(nums, i, j))
                    ans++;
        }
        return ans;
    }

    static boolean task(int[] nums, int start, int end) {
        for (int i = 0; i < start - 1; i++)
            if (nums[i] >= nums[i + 1])
                return false;
        if (start > 0 && end < nums.length - 1 && nums[start - 1] >= nums[end + 1])
            return false;
        for (int i = end + 1; i < nums.length - 1; i++)
            if (nums[i] >= nums[i + 1])
                return false;
        return true;
    }
}