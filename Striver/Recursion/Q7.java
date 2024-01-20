/****
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    public boolean isPalindrome2(String s) {                
        int j = s.length() - 1;
        for(int i = 0; i <j;) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(!isValidChar(left)) {
                i++;
                continue;
            }
            if(!isValidChar(right)) {
                j--;
                continue;
            }
            left = ('A'<= left && left <= 'Z') ? (char)(left - 'A' + 'a'): left;
            right =('A'<= right && right <= 'Z') ? (char)(right - 'A' + 'a'): right;
            if(left != right) return false;
            i++; j--;
                
        }

        return true;
    }

    private boolean isValidChar(char ch) {
        return ('0' <= ch && ch <= '9') ||  ('a' <= ch && ch <= 'z')  ||  ('A' <= ch && ch <= 'Z');
    }
}