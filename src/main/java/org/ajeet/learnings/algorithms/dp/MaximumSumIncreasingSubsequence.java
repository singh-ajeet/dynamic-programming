package org.ajeet.learnings.algorithms.dp;

public class MaximumSumIncreasingSubsequence {

    public static int get(int[] nums){
        return get(nums, 0, -1, 0);
    }

    private static int get(int[] nums, int current, int pre, int sum) {
        if(current >= nums.length)
            return sum;

        int sum1 = sum;
        if(pre == -1 || nums[current] > nums[pre])
            sum1 =  get(nums, current+1, current, sum + nums[current]);

        int sum2 = get(nums, current+1, pre, sum);

        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2,6,10,1,12};
        System.out.println(get(nums1));

        int[] nums2 = {-4,10,3,7,15};
        System.out.println(get(nums2));
    }
}
