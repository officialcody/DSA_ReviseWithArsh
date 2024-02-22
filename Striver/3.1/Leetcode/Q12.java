class Solution1 {
    public int singleNumber(int[] nums) {
        return xor( 0, nums);
    }
    public int xor(int n, int[] nums){
        if(n >= nums.length){
            return 0;
        }
        return nums[n] ^ xor(n+1,nums);
    }
}

class Solution2 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int answer = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}