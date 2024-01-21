/**
 * QUES 6 -> Letter Combinations of a Phone Number (LEETCODE - 17)
 * 
 * Company - Goldman Sachs 
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    Map<Character, List<Character>> alphabets = new HashMap<>();
    List<String> answer = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return answer;
        char ch = '2';
        char alp = 'a';
        while(ch <= '9') {
            List<Character> list = new ArrayList<Character>();
            if(ch == '7' || ch == '9') {
                for(int i=0;i<4;i++) {
                    list.add(alp++);
                }
            } else {
                for(int i=0;i<3;i++) {
                    list.add(alp++);
                }
            }
            alphabets.put(ch, list);
            ch++;
        }
        generateCombinations(digits, 0, new StringBuilder());
        return answer;
    }

    public void generateCombinations(String digits, int index, StringBuilder str) {
        if(index == digits.length()) {
            answer.add(str.toString());
            return;
        }
        List<Character> letters = alphabets.get(digits.charAt(index));
        for(Character letter:letters) {
            str.append(letter);
            generateCombinations(digits, index+1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}