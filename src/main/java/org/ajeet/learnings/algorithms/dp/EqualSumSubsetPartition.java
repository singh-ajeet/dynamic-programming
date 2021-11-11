package org.ajeet.learnings.algorithms.dp;

public class EqualSumSubsetPartition {

    /**
     * Brute force approach, it has exponantial complexity
     */
    public static boolean solveBruteForce(int[] nums){
        int sum = 0;
        for(int num :  nums){
            sum+=num;
        }

        if(sum % 2 != 0)
            return false;

        return solveBruteForce(nums, 0, sum/2);
    }

    private static boolean solveBruteForce(int[] nums, int index, int sum) {
        if(sum < 0 || index >= nums.length)
            return false;

        if(sum == 0)
            return true;

        boolean bool1 = solveBruteForce(nums, index+1, sum-nums[index]);
        boolean bool2 = solveBruteForce(nums, index + 1, sum);

        return bool1 || bool2;
    }

    public static boolean solve(int[] nums){
        int sum = 0;
        for(int num :  nums){
            sum+=num;
        }

        if(sum % 2 != 0)
            return false;

        sum = sum/2;
        int[][] dp = new int[sum+1][nums.length+1];
        int x= solve(nums, 0, sum, dp);

        return x == 1;
    }

    private static int solve(int[] nums, int index, int sum, int[][] dp) {
        if(sum < 0 || index >= nums.length)
            return 2;

        if (dp[sum][index] > 0)
            return dp[sum][index];

        if(sum == 0){
            dp[sum][index] = 1;
            return dp[sum][index];
        }

        int bool1 = solve(nums, index+1, sum-nums[index], dp);
        int bool2 = solve(nums, index + 1, sum, dp);

        if(bool1 == 1 || bool2 == 1){
            dp[sum][index] = 1;
        }

        return dp[sum][index];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(solveBruteForce(nums));
        System.out.println(solve(nums));
    }
}
