package org.ajeet.learnings.algorithms.dp;

public class SubsetSum {

    public static int sum(int[] nums){
        int sum = 0;
        for(int num : nums)
            sum+=num;

        int[][] dp =  new int[nums.length][sum/2 +1];
        return sum(nums, dp,0, 0, 0);
    }

    private static int sum(int[] nums, int[][] dp, int i, int sum1, int sum2) {
        if(i >= nums.length)
            return Math.abs(sum1-sum2);

        if(dp[i][sum1] == 0){
            dp[i][sum1] =  sum(nums,dp, i+1, sum1+nums[i], sum2);
            dp[i][sum2] = sum(nums,dp, i+1, sum1, sum2+nums[i]);
        }


        int result1 = dp[i][sum1];
        int result2 =  dp[i][sum2];

        return Math.min(result1, result2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 9};
        System.out.println(sum(nums));
    }
}
