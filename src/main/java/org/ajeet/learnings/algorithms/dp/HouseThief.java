package org.ajeet.learnings.algorithms.dp;

public class HouseThief {

    public static int steel(int[] values){
        return steel(values, 0, -1);
    }

    private static int steel(int[] values, int currentHouse, int lastHouse) {
        if(currentHouse >= values.length)
            return 0;

        int withCurrentHouse = values[currentHouse] + steel(values, currentHouse + 2, currentHouse);
        int withoutCurrentHouse = steel(values, currentHouse+1, lastHouse);

        return Math.max(withCurrentHouse, withoutCurrentHouse);
    }

    public static void main(String[] args) {
        int[] values= {2, 5, 1, 3, 6, 2, 4};
        int[] values2= {2, 10, 14, 8, 1};
        System.out.println(steel(values2));
    }
}
