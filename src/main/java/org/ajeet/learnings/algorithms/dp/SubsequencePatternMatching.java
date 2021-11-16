package org.ajeet.learnings.algorithms.dp;

public class SubsequencePatternMatching {

    public static int get(String t, String p){
        return get(t, p, 0, 0);
    }

    private static int get(String t, String p, int i, int j) {
        if(j == p.length())
            return 1;

        if(i == t.length())
            return 0;

        int c1 = 0;
        if(t.charAt(i) == p.charAt(j))
           c1 = get(t, p, i+1, j+1);

        int c2 = get(t, p, i+1, j);

        return c1 + c2;
    }

    public static void main(String[] args) {
        System.out.println(get("baxmx", "ax"));
        System.out.println(get("tomorrow", "tor"));
    }
}
