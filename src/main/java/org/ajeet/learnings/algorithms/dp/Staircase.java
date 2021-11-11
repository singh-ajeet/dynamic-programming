package org.ajeet.learnings.algorithms.dp;

public class Staircase {

    public static int countWays(int n){
        if(n == 1)
            return 1;

        if(n==2)
            return 2;

        return countWays(n-1) + countWays(n-2);
    }

    public static void main(String[] args) {
        System.out.println(countWays(3));
    }
}
