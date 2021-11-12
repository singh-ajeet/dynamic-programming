package org.ajeet.learnings.algorithms.dp;

public class LongestPalindromicSubsequence {

    public static int get(String text){
        return get(text, 0, text.length()-1);
    }

    private static int get(String text, int from, int to) {
        if(from == to)
            return 1;

        if(from > to)
            return 0;

        if(text.charAt(from) == text.charAt(to))
            return 2 + get(text, from+1, to-1);

        return Math.max(get(text, from+1, to), get(text, from, to-1));
    }

    public static void main(String[] args) {
        System.out.println("abdbca" + "=>" + get("abdbca"));
        System.out.println("cddpd" + "=>" + get("cddpd"));
        System.out.println("pqr" + "=>" + get("pqr"));
    }
}
