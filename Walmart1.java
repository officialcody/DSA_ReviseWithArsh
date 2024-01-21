/**
 * QUES 1 -> Find Subsequence of Length K With the Largest Sum (LEETCODE - 2099)
 * 
 * Company - Walmart
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int array[][] = new int[k][2];
        
        for(int j = 0;j<nums.length;j++){
            pq.add(new int[]{nums[j], j});
        }
        int i = 0;
        while(i<k){
            array[i][0] = pq.peek()[0];
            array[i][1] = pq.peek()[1];
            pq.poll();
            i++;
        }
        
       Arrays.sort(array, (a, b) -> a[1] - b[1]);
       int arr[] = new int[k];
        for(int j = 0; j<arr.length;j++){
            arr[j] = array[j][0];
        }
        return arr;
    }
}