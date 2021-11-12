package org.ajeet.learnings.algorithms.dp;

public class CountPalindromicSubstring {

    public static int get(String text){
        return get(text, 0, text.length()-1);
    }

    private static int get(String text, int from, int to) {
        if(from > to)
            return 0;

        if(from == to) {
            return 1;
        }

        int totalCount = 0;
        if(isPalindrome(text, from, to)){
            totalCount =  1;
        }

        totalCount+= get(text, from+1, to);
        totalCount+= get(text, from, to-1);
        //We calculated this two times as part of above two recursive calls so need to subtract it
        totalCount-= get(text, from + 1, to - 1);

        return totalCount;
    }

    private static boolean isPalindrome(String text, int from, int to) {
        while(from < to){
            if(text.charAt(from) != text.charAt(to))
                return false;
            from++;
            to--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("abdbca" + "=>" + get("abdbca"));
        System.out.println("cddpd" + "=>" + get("cddpd"));
        System.out.println("pqr" + "=>" + get("pqr"));
    }
}
