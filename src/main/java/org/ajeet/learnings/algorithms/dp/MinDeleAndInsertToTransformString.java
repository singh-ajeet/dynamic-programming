package org.ajeet.learnings.algorithms.dp;

public class MinDeleAndInsertToTransformString {

    public static int get(String s1, String s2){
        return get(s1, 0, s2, 0);
    }

    private static int get(String s1, int i1, String s2, int i2) {
        if(i1 == s1.length() || i2 == s2.length())
            return 0;

        if(s1.charAt(i1) == s2.charAt(i2)){
            return  get(s1, i1 + 1, s2, i2 + 1);
        }

        int count1 = 1 + get(s1, i1 + 1, s2, i2);
        int count2 = 1 + get(s1, i1, s2, i2 + 1);

        return Math.min(count1,count2);
    }

    public static void main(String[] args) {
        System.out.println(get("abc", "fbc"));
        System.out.println(get("passport", "ppsspt"));
    }
}
