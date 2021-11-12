package org.ajeet.learnings.algorithms.dp;

public class NumberFactors {

    public static int count(int n){
        if(n == 0)
            return 1;

        if(n == 1)
            return 1;

        if(n == 2)
            return 1;

        if(n == 3)
            return 2;

        return count(n-1) + count(n-3) + count(n-4);
    }

    public static void main(String[] args) {
        System.out.println(count(4));
    }
}
