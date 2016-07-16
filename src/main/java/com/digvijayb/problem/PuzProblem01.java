package com.digvijayb.problem;

/**
 * Created by digvijayb on 16/07/16.
 */
public class PuzProblem01 {

    public static void main(String[] args) {
        coinsProblem(13);
        getSafePosition(12);
        secondHighest();
    }


    static int coinsProblem(int i) {
        int count = 0;
        int val = i;
        int[] coins = {20, 10, 5, 1};

        int left = val;
        int remain = 0;
        for (int coin : coins) {
            remain = left % coin;
            if (remain >= 0) {
                count += left / coin;
                left = remain;
            }
        }

        System.out.println("coins require " + count);

        return count;
    }

    static int getSafePosition(int n) {
        // find value of L for the equation

        int valueOfL = n - Integer.highestOneBit(n);
        int safePosition = 2 * valueOfL + 1;

        return safePosition;
    }


    static int secondHighest() {

        int[] arr = {9, 7, 2, 5, 1, 8, 10, 2, 5, 7, 0};
        int a, b, c;
        a = b = c = 0;

        for (int i = 0; i < arr.length; i++) {
            if (a < arr[i]) {
                b = a;
                a = arr[i];
            } else if (b < arr[i]) {
                b = arr[i];
            }
        }

        System.out.println("the second highest is " + b);
        return b;

    }

}
