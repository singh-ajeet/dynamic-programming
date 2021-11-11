package org.ajeet.learnings.algorithms.dp;

public class CoinChangeMinWays {

    public static int count(int[] coins, int amount) {
        return count(coins, amount, 0);
    }

    private static int count(int[] coins, int amount, int i) {
        if(amount == 0)
            return 0;

        if(i >= coins.length){
               return Integer.MAX_VALUE;
        }

        //After including this coin
        int ways1 = Integer.MAX_VALUE;
        if(coins[i] <= amount) {
            int ways = count(coins, amount-coins[i], i);
            if(ways != Integer.MAX_VALUE){
                ways1 = ways + 1;
            }
        }
        //After excluding this coin
        int ways2 = count(coins, amount, i+1);

        return Math.min(ways1, ways2);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println(count(coins, 5));
    }
}
