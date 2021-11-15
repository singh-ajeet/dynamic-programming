package org.ajeet.learnings.algorithms.dp;

public class MinimumDeletionsToMakePalindrome {

    public static int get(String txt){
        return get(txt, 0, txt.length()-1);
    }

    private static int get(String txt, int from, int to) {
        if(from >= to)
            return 0;

        if(txt.charAt(from) == txt.charAt(to))
            return get(txt, from+1, to-1);

        int removeFirst = 1 + get(txt, from+1, to);
        int removeLast = 1+ get(txt, from, to-1);

        return Math.min(removeFirst, removeLast);
    }

    public static void main(String[] args) {
        System.out.println("abdbca" + "=>" + get("abdbca"));
        System.out.println("cddpd" + "=>" + get("cddpd"));
        System.out.println("pqr" + "=>" + get("pqr"));
    }
}
