class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maximumConsecutiveOnes = 0;
        int counter = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 1) {
                counter++;
                maximumConsecutiveOnes = Math.max(maximumConsecutiveOnes, counter);
            } else {
                counter = 0;
            }
        }
        return maximumConsecutiveOnes;
    }
}