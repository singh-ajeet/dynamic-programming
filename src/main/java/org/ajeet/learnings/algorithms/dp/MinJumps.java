package org.ajeet.learnings.algorithms.dp;

public class MinJumps {

    public static int count(int[] jumps){
        return count(jumps, 0);
    }

    private static int count(int[] jumps, int i) {
        if(i == jumps.length - 1)
            return 0;

        if(jumps[i] == 0)
            return Integer.MAX_VALUE;

        int from = i +1;
        int to = i + jumps[i];
        int minJums = Integer.MAX_VALUE;
        while (from <= to && to < jumps.length){
            int jumpsMade = count(jumps, from);

            if(jumpsMade != Integer.MAX_VALUE)
                minJums = Math.min(minJums, jumpsMade + 1);

            from++;
        }
        return minJums;
    }

    public static void main(String[] args) {
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(count(jumps));
    }
}
