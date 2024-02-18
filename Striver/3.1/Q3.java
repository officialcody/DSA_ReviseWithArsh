/***
 * 1752. Check if Array Is Sorted and Rotated
 * Leetcode Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
 */

class Solution {
    // If there is more than one saturation points in the array, it cannot be rotated and sorted
    // If there is a single saturation point we need to check the first and last elements of the array for this we are using %n
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] > nums[(i+1)%n]) {
                count++;
            }
        }
        return count <= 1;
    }

    public boolean check2(int []nums) {
        int n = nums.length;
        int rotations = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                rotations++;
                if (rotations > 1) {
                    return false;
                }
            }
        }
        if (rotations == 1) {
            return nums[n-1] <= nums[0];
        }
        return true;
    }
}