/**
 * QUES 8 -> Wiggle Sort II (LEETCODE - 324)
 * 
 * Company - Microsoft
 * 
 * #revisewitharsh
 * #6companies30dayschallenge
 */
// Approach 1:
class Solution {
    // O(nlogn)
    public void wiggleSort(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        // Create a temp array
        int n = nums.length;
        int [] res = new int[n];
        // set greater elements using i = 1 and other odd indices
        int i = 1;
        int j = n - 1;
        while(i < n) {
            res[i] = nums[j];
            i += 2;
            j--;
        }
        // Once all odd indices are filled, set i = 0
        i = 0;
        // fill all even indices with lesser elements
        while(i < n) {
            res[i] = nums[j];
            i += 2;
            j--;
        }
        // copy temporary array elements to main array
        for(i =0;i<n;i++) {
            nums[i] = res[i];
        }
    }
}
// Approach 2:
class Solution2 {
    // Using Count Sort
    public void wiggleSort(int[] nums) {
        //0 <= nums[i] <= 5000
        //min = 0, max = 5000
        //fill max available value on even positions then on odd positions
        int[] bucket = new int[5001];
        for(int i: nums)
            bucket[i]++;
        
        int max = 5000;
        boolean firstPass = true;
        for(int i = 1 ; i < nums.length; i+=2){
            while(bucket[max] == 0)
                max--;
            nums[i] = max;
            bucket[max]--;
            if(firstPass && i+2 >= nums.length){
                i = -2; // want to set i = 0 but since at the end it does i+2 so making it i = -2 to get resultant = 0
                firstPass = false;
            }
        }
        
    }
}