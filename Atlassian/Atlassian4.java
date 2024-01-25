/**
 * QUES 4 -> Count Collisions on a Road (LEETCODE - 2211)
 * 
 * Company - Atlassian
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    // Approach 1 - Using Stack
    public int countCollisions(String directions) {
        if(directions.length() == 1) return 0;
        int collisions = 0;
        Stack<Character> stack = new Stack();
        stack.push(directions.charAt(0));
        for(int i = 1;i<directions.length();i++){
            char curr = directions.charAt(i);
            if((stack.peek()== 'R' && curr == 'L')  ){
                collisions+=2;
                stack.pop();
                curr = 'S';
            } else if((stack.peek() == 'S' && curr == 'L')){
                curr = 'S';
                collisions+=1;
            }
            while(!stack.isEmpty() && ((stack.peek() == 'R' && curr == 'S') )){
                collisions+=1;
                stack.pop();
            }
            
            stack.push(curr);
        }
        return collisions;
    }

    // Approach 2 - To skip all leading L's and Trailing R's and then iterate the remaining L and R's and keep a count of only L and R. Then return the count
    public int countCollisions2(String dir) {
        int i = 0;
        int j = dir.length() - 1;
        int count = 0;
        while(i<dir.length() && dir.charAt(i) == 'L'){
            i++;
        }
        while(j>=0 && dir.charAt(j) == 'R'){
            j--;
        }
        for(int it = i;it<=j;it++){
            if(dir.charAt(it) != 'S'){
                count++;
            }
        }
        return count;
    } 
}