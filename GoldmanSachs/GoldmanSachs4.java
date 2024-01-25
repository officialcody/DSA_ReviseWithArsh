/**
 * QUES 4 -> Combination Sum III (LEETCODE - 216)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubSets(1, 9, new ArrayList<Integer>(), subsets, k, n);
        return subsets;
    }

    public void generateSubSets(int start, int end, List<Integer> current, List<List<Integer>> subsets, int k, int target) {
        if(target == 0 && current.size() == k) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<=end;i++) {
            current.add(i);
            generateSubSets(i+1, end, current, subsets, k, target - i);
            current.remove(current.size() - 1);
        }
    }
}