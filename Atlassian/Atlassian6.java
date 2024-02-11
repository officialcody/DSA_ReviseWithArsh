/**
 * QUES 6 -> Count Words obtained after adding a letter (LEETCODE - 2135)
 * 
 * Company - Atlassian
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> set = new HashSet();
        for (String s : startWords) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            set.add(new String(a));
        }
        int count = 0;
        for (String t : targetWords) {
            int n = t.length();
            for (int i = 0; i < n; i++) {
                String s = t.substring(0, i) + t.substring(i + 1); // skip ith index
                char[] a = s.toCharArray();
                Arrays.sort(a);
                s = new String(a);
                if (set.contains(s)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}