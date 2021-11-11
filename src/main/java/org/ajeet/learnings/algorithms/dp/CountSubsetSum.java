package org.ajeet.learnings.algorithms.dp;

public class CountSubsetSum {

    public static int count(int[] nums, int sum){
      //  int[][] dp =  new int[nums.length][sum];
        return count(nums, 0, sum);
    }

    private static int count(int[] nums, int i, int sum) {
        //We found 1 subset
        if(sum == 0)
            return 1;

        //We did not found a subset and reached the end
        if(i >= nums.length)
            return 0;

        int countWithElement = 0;
        if(nums[i] <= sum)
            countWithElement = count(nums, i+1, sum-nums[i]);

        int countWithoutElement = count(nums, i+1, sum);

        return countWithElement + countWithoutElement;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        System.out.println(count(nums, 5));
    }
}
