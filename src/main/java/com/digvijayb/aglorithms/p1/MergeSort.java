package com.digvijayb.aglorithms.p1;

import com.sun.istack.internal.NotNull;

/**
 * Created by digvijayb on 25/2/15.
 */
public class MergeSort {

    public static int[] mergeSort(@NotNull int arr[]){
        int aux[] = new int[arr.length];
        System.arraycopy(arr, 0, aux, 0, arr.length);
        mergeSort0(arr,aux,0,aux.length-1);
        return arr;
    }


    private static void mergeSort0(int arr[], int aux[], int lo,int hi){
        int mid = hi + lo / 2;
        sort(arr,aux,lo,mid);
        sort(arr,aux,mid,hi);
        merge(arr, aux,lo,mid,hi);
    }

    private static void sort(int arr[], int aux[], int lo,int hi){
        int mid = hi + lo / 2;
        if(lo != mid){
            sort(arr,aux,lo,mid);
            sort(arr, aux, mid, hi);
            merge(arr, aux, lo, mid, hi);
        }else if(aux[hi] < aux[lo]){
           System.out.println(aux[hi]+" : "+aux[lo]);
            swap(aux, hi, lo);
        }else {
            System.out.println(aux[hi]+" : "+aux[lo]);
        }

    }



    private static void merge(int arr[], int aux[], int lo,int mid, int hi){
        int h = hi;
        int l = lo;
        int m = mid;
        for(int i = lo; i < hi; i++){
            if(l > mid){
                arr[i] = aux[m++];
            }else if(m > hi){
                arr[i] = aux[l++];
            }else if(aux[l] > aux[m]) {
                //swap(aux, m++, l);
                arr[i] = aux[m++];
            }else {
                //swap(aux, l++, m);
                arr[i] = aux[l++];
            }
        }

    }

    private static void swap(int[] aux, int m, int n){
        int temp = aux[m];
        aux[m] = aux[n];
        aux[n] = temp;
    }


    public static void runMergeSort(){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        mergeSort(arr);
        for (int i : arr){
            System.out.print(i+", ");
        }
    }


}
