package com.digvijayb.aglorithms.sample;


import java.util.Arrays;

/**
 * Created by digvijayb on 2/21/2016.
 */
public class ArrayPrint {



    public static void main(String[] args) {

        // array
        String[] arrayStr = new String[]{"Java", "Node", "Python", "Ruby"};
        Arrays.stream(arrayStr).forEach(System.out::print);

        System.out.println();

        int[] arrayInt = {1, 3, 5, 7, 9};
        Arrays.stream(arrayInt).forEach(System.out::print);

        System.out.println();
        //2d array
        String[][] deepArrayStr = new String[][]{{"mkyong1", "mkyong2"}, {"mkyong3", "mkyong4"}};
        Arrays.stream(deepArrayStr).flatMap(x -> Arrays.stream(x)).forEach(System.out::print);

        System.out.println();
        int[][] deepArrayInt = new int[][]{{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}};
        Arrays.stream(deepArrayInt).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::print);

    }


}
