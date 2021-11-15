package org.ajeet.learnings.algorithms.dp;

public class LongestCommonSubstring {

    public static int get(String s1, String s2){
        return get(s1, 0, s2, 0, 0);
    }

    private static int get(String s1, int i1, String s2, int i2, int count) {
        if(i1 == s1.length() || i2 == s2.length())
            return count;

        if(s1.charAt(i1) == s2.charAt(i2)){
            count =  get(s1, i1 + 1, s2, i2 + 1, count+1);
        }

        int l2 = get(s1, i1 + 1, s2, i2, 0);
        int l3 = get(s1, i1, s2, i2 + 1, 0);

        return Math.max(count, Math.max(l2, l3));
    }

    public static void main(String[] args) {
        System.out.println(get("abdca", "cbda"));
        System.out.println(get("passport", "ppsspt"));
    }
}
