package com.digvijayb.aglorithms.p1;

/**
 * Created by digvijayb on 1/2/15.
 */
public class InsertionSort {

    public static int[] sort(int[] a) {
        printArray(a);
        return sort0(a);
    }

    private static int[] sort0(int[] a){
        int mc = 0;
        for(int i = 0; i < a.length; i++){
           for(int j = i; j > 0 && a[j-1] > a[j]; j--) {
               swap(a, j-1, j);
               mc++;
           }
        }
        System.out.println("count " + mc);
        return a;
    }

    private static void swap(int[] r, int a, int b){
        r[a] = r[a] + r[b];
        r[b] = r[a] - r[b];
        r[a] = r[a] - r[b];
    }

    public static void printArray(int[] a){
        for(int i : a){
            System.out.printf(" %d ,",i);
        }
        System.out.println();
    }

    public static void main(String... args){
        int [] a = new int[]{7,3};
        swap(a,0,1);
        printArray(a);
        printArray(sort(new int[]{0, 9, 4, 3, 2, 7, 3, 82, 4, 73, 2}));
    }

}
