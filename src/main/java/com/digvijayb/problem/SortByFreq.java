package com.digvijayb.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by digvijayb on 16/07/16.
 */
public class SortByFreq {

    public static void main(String... args) {
        int[] inputArray = {2, 3, 4, 2, 1, 2, 1, 8, 9};
        int[] out = manipulateArray(inputArray);
        printArr(out);

    }

    static int[] manipulateArray(int[] inputArray) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = inputArray.length;
        int[] output = new int[len];
        for (int i : inputArray) {
            if (map.containsKey(i)) {
                Integer feq = map.get(i) + 1;
                map.put(i, feq);
            } else {
                map.put(i, 1);
            }
        }

        System.out.println(map);

        Arrays.sort(inputArray);
        //Collection<Integer> values = map.values();
        int temp = 0;
        printArr(inputArray);
        for (int i = 0; i < len; i++) {
            //output[i] = inputArray[i];
            for (int j = i; j < len; j++) {
                if (map.get(inputArray[j]) > map.get(inputArray[i])) {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }

        return inputArray;

    }


    static void printArr(int[] a) {
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println("======");
    }
}
