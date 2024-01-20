/**
 * You are given an integer ’n’.
 * Your task is to return a sorted array (in increasing order) containing all the factorial numbers which are less than or equal to ‘n’.
 * The factorial number is a factorial of a positive integer, like 24 is a factorial number, as it is a factorial of 4.
 */
import java.util.*;

public class Solution {
    public static List<Long> factorialNumbers(long n) {
        List<Long> numbers = new ArrayList<Long>();
        factorials(numbers, 1L, n);
        return numbers;
    }

    public static void factorials(List<Long> numbers, long curr, long n) {
        if(curr > n) return;
        if(factorial(curr) <= n) {
            numbers.add(factorial(curr));
        } else {
            return;
        }
        curr++;
        factorials(numbers, curr, n);
    }

    public static long factorial(long n) {
        long answer = 1;
        for(int i=1;i<=n;i++) {
            answer *= i;
        }
        return answer;
    }
}