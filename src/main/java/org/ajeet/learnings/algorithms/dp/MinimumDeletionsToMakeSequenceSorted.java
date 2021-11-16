package org.ajeet.learnings.algorithms.dp;

public class MinimumDeletionsToMakeSequenceSorted {

    public static int get(int[] nums){
        int sortedLength =  get(nums, 0, 0);
        return nums.length - sortedLength;
    }

    private static int get(int[] nums, int pre, int curr) {
        if(curr == nums.length)
            return 0;

        int len1 = 0;
        if(nums[curr] >= nums[pre])
            len1 = 1 + get(nums, curr, curr+1);

        int len2 = get(nums, pre, curr+1);
        int len3 = get(nums, curr, curr+1);

        return Math.max(len1, Math.max(len2, len3));
    }

    public static void main(String[] args) {
        int[] nums1 = {4,2,3,6,10,1,12};
        System.out.println(get(nums1));

        int[] nums2 = {-4,10,3,7,15};
        System.out.println(get(nums2));

        int[] nums3 = {3,2,1,0};
        System.out.println(get(nums3));
    }
}
