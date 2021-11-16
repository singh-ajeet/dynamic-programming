package org.ajeet.learnings.algorithms.dp;

public class LongestRepeatingSubsequence {

    public static int get(String str){
        return get(str, 0, 0);
    }

    private static int get(String str, int i, int j) {
        if(i == str.length() || j == str.length())
            return 0;

        if(i != j && str.charAt(i) ==str.charAt(j))
           return 1 + get(str, i+1, j+1);

        int len2 = get(str, i+1, j);
        int len3 = get(str, i, j+1);

        return Math.max(len2, len3);
    }

    public static void main(String[] args) {
        System.out.println(get("tomorrow"));
    }
}
