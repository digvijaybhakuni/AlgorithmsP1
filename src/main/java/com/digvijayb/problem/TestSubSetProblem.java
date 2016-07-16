package com.digvijayb.problem;

import java.util.Arrays;

/**
 * Created by digvijayb on 16/07/16.
 */
public class TestSubSetProblem {

    public static void main(String[] args) {

        int[] arr = {-1, 8, 4, -2, 5, -9, 56, 9, -5, 9, 8, -8, -9};
        int len = arr.length;
        int maxSum = 0;
        int maxTemp = 0;
        int s = 0, e = 0, tempS = 0, tempE = 0;
        boolean isSeq = false;
        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) {
                if (!isSeq) {
                    tempS = i;
                }
                maxTemp += arr[i];
                isSeq = true;
            } else if (isSeq) {
                tempE = i - 1;
                if (maxTemp > maxSum) {
                    maxSum = maxTemp;
                    s = tempS;
                    e = tempE;
                }
                maxTemp = 0;
                isSeq = false;
            }
        }

        print(Arrays.copyOfRange(arr, s, e + 1));

    }

    static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
