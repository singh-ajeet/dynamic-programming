package org.ajeet.learnings.algorithms.dp;

public final class Knapsack01 {

    /**
     * Brute forcde approach, without memoization. complexity is exponantial
     */
    public static int solveByBruteForce(int[] itemsWeight, int[] itemsValue, int capacity){
       return solveByBruteForce(itemsWeight, itemsValue, capacity, 0);
    }

    private static int solveByBruteForce(int[] itemsWeight, int[] itemsValue, int remaningCapacity, int index) {
        if(remaningCapacity <= 0 || index >= itemsWeight.length)
            return 0;

        int profit1 = 0;
        if(itemsWeight[index] <= remaningCapacity)
            profit1 = itemsValue[index] + solveByBruteForce(itemsWeight, itemsValue, remaningCapacity - itemsWeight[index], index + 1);

        int profit2 =  solveByBruteForce(itemsWeight, itemsValue, remaningCapacity, index + 1);

        return Math.max(profit1, profit2);
    }

    /**
     * Memoizatione approach, without memoization. complexity is exponantial
     */
    public static int solve(int[] itemsWeight, int[] itemsValue, int capacity){
        int dp[][] = new int[capacity+1][itemsWeight.length+1];
        return solve(itemsWeight, itemsValue, capacity, 0, dp);
    }

    private static int solve(int[] itemsWeight, int[] itemsValue, int remaningCapacity, int index,  int dp[][]) {
        if(remaningCapacity <= 0 || index >= itemsWeight.length)
            return 0;

        if(dp[remaningCapacity][index] > 0){
            return dp[remaningCapacity][index];
        }

        int profit1 = 0;
        if(itemsWeight[index] <= remaningCapacity)
            profit1 = itemsValue[index] + solve(itemsWeight, itemsValue, remaningCapacity - itemsWeight[index], index + 1, dp);

        int profit2 =  solve(itemsWeight, itemsValue, remaningCapacity, index + 1, dp);
        dp[remaningCapacity][index] = Math.max(profit1, profit2);
        return dp[remaningCapacity][index];

    }
    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        System.out.println(solveByBruteForce(weights, profits, 7));
        System.out.println(solve(weights, profits, 7));
    }
}
