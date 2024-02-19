class Solution1 {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int i=0;i<nums.length;i++) {
            if(map.get(nums[i]) > 1) {
                map.put(nums[i], map.get(nums[i]) - 1);
            }
        }

        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[index] = entry.getKey();
            index++;
        }
        return map.size();
    }
}

/*****
 * Intuition
 * We can think of using two pointers ‘i’ and ‘j’, we move ‘j’ till we don’t get a number arr[j] which 
 * is different from arr[i]. As we got a unique number we will increase the i pointer and update its value by arr[j].
 * 
 * Approach
 * Take a variable i as 0;
 * Use a for loop by using a variable ‘j’ from 1 to length of the array.
 * If arr[j] != arr[i], increase ‘i’ and update arr[i] == arr[j].
 * After completion of the loop return i+1, i.e size of the array of unique elements.
 * 
 */

class Solution {
    public int removeDuplicates(int[] arr) {
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
        
    }
}