package org.ajeet.learnings.algorithms.dp;

public class CoinChange {

    public static int count(int[] coins, int amount) {
        return count(coins, amount, 0);
    }

    private static int count(int[] coins, int amount, int i) {
        if(amount == 0)
            return 1;

        if(i >= coins.length){
            return 0;
        }

        //After including this coin
        int ways1 = 0;
        if(coins[i] <= amount)
            ways1 = count(coins, amount-coins[i], i);
        //After excluding this coin
        int ways2 = count(coins, amount, i+1);

        return ways1 + ways2;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println(count(coins, 5));
    }
}
