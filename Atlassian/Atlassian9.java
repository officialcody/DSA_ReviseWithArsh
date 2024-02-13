/**
 * QUES 9 -> Kth largest element in a stream (LEETCODE - 703)
 * 
 * Company - Atlassian
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class KthLargest {
    int kth;
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    public KthLargest(int k, int[] nums) {
        this.kth = k;
        for(int number : nums) this.add(number);
    }
    
    public int add(int val) {
        this.queue.offer(val);
        if(this.queue.size() > kth) this.queue.poll();
        return this.queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */