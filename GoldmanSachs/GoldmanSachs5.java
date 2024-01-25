/**
 * QUES 5 -> Random Flip Matrix (LEETCODE - 519)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */

 // Approach 1 - HashSet and Math.random()

 class Solution {
    private int m;
    private int n;
    private HashSet<String> mat;

    public Solution(int m, int n) {
        mat = new HashSet<>();
        this.m = m;
        this.n = n;
    }
    
    public int[] flip() {
        int r = (int) (Math.random() * m);
        int c = (int) (Math.random() * n);
        
        while(mat.contains(r + " " + c)){
            r = (int) (Math.random() * m);
            c = (int) (Math.random() * n);
        }
            
        int output[] = {r, c};
        mat.add(r + " " + c);
                               
        return output;
    }
    
    public void reset() {
        mat.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */

// Approach 2

// class Solution {
//     int i = 0;
//     int j = 0;
//     int m = 0;
//     int n = 0;
//     public Solution(int m, int n) {
//         this.m = m;
//         this.n = n;
//     }
    
//     public int[] flip() {
//         if(i >= m || j >= n) return null;
//         int [] result = new int[]{i,j};
//         j++;
//         if(j == n) {
//             j = 0;
//             i++;
//         }
//         if(i == m) {
//             i = 0;
//             j = 0;
//         }
//         return result;
//     }
    
//     public void reset() {

//     }
// }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */