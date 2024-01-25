/**
 * QUES 3 -> K-diff pairs in an Array (LEETCODE - 532)
 * 
 * Company - Walmart
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    // Approach 1: Using HashMap
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
 			for (int num : nums)
 				map.put(num, map.getOrDefault(num, 0) + 1);

        int result = 0;
        for (int i : map.keySet())
            if (k > 0 && map.containsKey(i + k) || k == 0 && map.get(i) > 1)
                result++;
        return result;
    }

    // Approach 2: Using HashSet and Sorting
 	public int findPairs2(int[] nums, int k) {
 		Set<Integer> uniquePair = new HashSet();
 		Arrays.sort(nums);
 		int n = nums.length;

 		for (int i = 0; i < n - 1; i++)
 			if (Arrays.binarySearch(nums, i + 1, n, nums[i] + k) > 0)
 				uniquePair.add(nums[i]);

 		return uniquePair.size();
 	}
}