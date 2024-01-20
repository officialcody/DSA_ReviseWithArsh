/**
 * Print Name n number of times
 */

import java.util.*;
public class Solution {
    public static List<String> printNtimes(int n){
        List<String> names = new ArrayList<String>();
        printNames(names, n);
        return names;
    }

    public static void printNames(List<String> names, int n) {
        if(n == 0) return;
        names.add("Coding Ninjas");
        printNames(names, n - 1);
    }
}