package com.digvijayb.aglorithms.p1;

import java.util.Random;

/**
 * Created by digvijayb on 23/2/15.
 */
public class Shuffling {

    public static Random random = null;

    public static int[] shuffle(int[] arr){

        initRandom();
        int len = arr.length;
        for(int i = 0; i < len; i++){
            exch(arr, i, uniform(i+1));
        }
        return arr;
    }

    public static int uniform(int n){

        n = random.nextInt(n);
        return n;
    }

    private static void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void initRandom(){
        if(random==null) {
            random = new Random();
        }
    }

}
