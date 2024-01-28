/**
 * QUES 4 -> Find the winner of Circular Game (LEETCODE - 1823)
 * 
 * Company - Microsoft
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    // Approach 1: Using List to track the winner (BRUTE FORCE)
    public int findTheWinner(int n, int k) {
        List<Integer> list =new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int count=0;
        while(list.size()>1){
            for(int i=0;i<list.size();i++){
                count++;
                if(list.size()==1) return list.get(0);
                if(count==k) {
                    list.remove(i);
                    i--;
                    count=0;
                }
            }
        }
        return list.get(0);
    }
}

//Solution 2: Using Recursion
// class Solution {
//     public int findTheWinner(int n, int k) 
//     {
//         int v=find(n,k);
//         return v+1;
//     }
//     public static int find(int n,int k)
//     {
//         if(n==1)
//         {
//             return 0;
//         }
//         int x=find(n-1,k);
//         int y=(x+k)%n;
//         return y;  
//     }
// }