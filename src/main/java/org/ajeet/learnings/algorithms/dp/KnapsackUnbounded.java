package org.ajeet.learnings.algorithms.dp;

public class KnapsackUnbounded {

    public static int profit(int[] weights, int[] profits, int capacity){
        return profit(weights, profits, capacity, 0);
    }

    private static int profit(int[] weights, int[] profits, int capacity, int i) {
        if(i>= weights.length)
            return 0;

        int profit1 = 0;
        if(weights[i] <= capacity)
            profit1 = profits[i] + profit(weights, profits, capacity - weights[i], i);

        int profit2 = profit(weights, profits, capacity, i+1);

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3 };
        int[] profits = { 15, 20, 50 };

        System.out.println(profit(weights, profits, 5));
    }
}
