package org.ajeet.learnings.algorithms.dp;

public class PalindromicPartition {

    public static int get(String txt) {
        return get(txt, 0, txt.length()-1);
    }

    private static int get(String txt, int from, int to) {
        if(from > to) {
            return 0;
        }

        if(isPalindrome(txt, from, to)) {
            return 0;
        }

        int maxChanges = to-from;
        for (int i= from; i<= to; i++){
            if(isPalindrome(txt, from, i)) {
                maxChanges = Math.min(maxChanges, 1 + get(txt, i+1, to));
            }
        }

        return maxChanges;
    }

    private static boolean isPalindrome(String txt, int from, int to) {
        while (from < to){
            if(txt.charAt(from) != txt.charAt(to)) {
                return false;
            }
            from++;
            to--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("abdbca" + "=>" + get("abdbca"));
        System.out.println("cddpd" + "=>" + get("cddpd"));
        System.out.println("pqr" + "=>" + get("pqr"));
        System.out.println("pp" + "=>" + get("pp"));
    }
}
