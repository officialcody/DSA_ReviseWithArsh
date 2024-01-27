/**
 * QUES 9 -> Finding consecutive integers from a data stream (LEETCODE - 2526)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */


/***
 * ********** Solution 1: Using Queue
 */
class DataStream {
    Queue<Integer> queue;
    int value, k;
    public DataStream(int value, int k) {
        this.queue = new LinkedList<Integer>();
        this.value = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        if(num == this.value) {
            this.queue.add(num);
        } else {
            this.queue = new LinkedList<>();
        }
        return this.queue.size() >= k;
    }
}

/*********
 * ***************** Solution 2: Using class/member variables
 */
// class DataStream {
//     int currentStreak = 0;
//     int value, k;
//     public DataStream(int value, int k) {
//         this.k = k;
//         this.value = value;
//     }
//     public boolean consec(int num) {
//         if (num != value) {
//             currentStreak = 0;
//         } else {
//             currentStreak++;
//         }
//         return currentStreak >= k;
//     }
// }

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */