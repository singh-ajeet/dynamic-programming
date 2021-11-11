package org.ajeet.learnings.algorithms.dp;

public class FibonacciNumbers {

    public static int nth(int n){
        if(n < 2)
            return n;

        int[]dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        return nth(n, dp);
    }

    private static int nth(int n, int[] dp) {
        if(dp[n] == 0)
            dp[n] = nth(n-1) + nth(n-2);

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(nth(5));
    }
}
