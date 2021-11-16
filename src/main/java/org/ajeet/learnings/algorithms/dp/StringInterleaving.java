package org.ajeet.learnings.algorithms.dp;

public class StringInterleaving {

    public static boolean get(String m, String n, String p){
        return get(m,n,p,0,0,0);
    }

    private static boolean get(String m, String n, String p, int i, int j, int k) {
        if(i == m.length() && j == n.length() && k == p.length()) {
            return true;
        }

        if( k == p.length()) {
            return false;
        }

        boolean firstMatch = false;
        if(i < m.length() && (m.charAt(i) == p.charAt(k))) {
            i++;
            firstMatch = true;
        }

        boolean secondMatch = false;
        if(j < n.length() && (n.charAt(j) == p.charAt(k))) {
            j++;
            secondMatch = true;
        }

        if(!firstMatch && !secondMatch){
            return false;
        }

        k++;
        return get(m,n,p, i, j, k);
    }

    public static void main(String[] args) {
        System.out.println(get("abd", "cef", "abcdef"));
        System.out.println(get("abd", "cef", "adcbef"));
        System.out.println(get("abcdef", "mnop", "mnaobcdepf"));
    }
}
