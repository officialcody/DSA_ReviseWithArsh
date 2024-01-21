/**
 * Leetcode 1838. Frequency of the Most Frequent Element
 */
class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Find MIN and MAX of nums array
        int MIN = nums[0], MAX = nums[0];
        for(int i=0; i<nums.length; i++) {
            MIN = Math.min(MIN, nums[i]);
            MAX = Math.max(MAX, nums[i]);
        }

        // Sort numbers using counting cort
        int N = MAX-MIN+1;
        int[] counts = new int[N];
        for(int i=0; i<nums.length; i++) 
            counts[nums[i]-MIN]++;

        // Sliding Window on count Array
        int left, right, operations, length, maxLength;
        left = right = operations = 0;
        length = maxLength = counts[0];
        boolean extend = true; 
        while(left < N) {
            // Determine whether to extend or shrink window
            extend = (right == N-1) ? false : true;
            if(operations > k)
                extend = false;
            else
                maxLength = Math.max(maxLength, length);

            // Perform extending or shrinking on window
            if(extend == true) {
                int prevRight = right;
                right = findNextValidNumber(counts, right+1);
                operations += length * (right - prevRight);
                length += counts[right];
            }
            else {
                operations -= (right - left);
                counts[left]--;
                length--;
                if(counts[left] == 0)
                    left = findNextValidNumber(counts, left+1);
            }
        }
        return maxLength;
    }

    // Find next number having non zero count
    private int findNextValidNumber(int counts[], int num) {
        while(num < counts.length && counts[num] == 0)
            num++;
        return num;
    }
}