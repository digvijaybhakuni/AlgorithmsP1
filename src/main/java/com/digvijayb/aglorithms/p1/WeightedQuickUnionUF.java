package com.digvijayb.aglorithms.p1;

/**
 * Created by digvijayb on 1/2/15.
 */
public class WeightedQuickUnionUF {

    private int[] array = null;
    private int[] sz = null;

    public WeightedQuickUnionUF(int lenght) {
        array = new int[lenght];
        sz = new int[lenght];
        for (int i = 0; i < lenght; i++){
            array[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i){
        while (i!=array[i]){
            array[i] = array[array[i]];
            i = array[i];
        }
        return i;
    }

    public boolean connected(int a, int b){
        return (root(a)==root(b));
    }

    public void union(int a, int b){
        int ra = root(a);
        int rb = root(b);
        if (ra==rb) return;
        if(sz[ra] < sz[rb]){
            array[ra] =   rb;
            sz[rb] += sz[ra];
        }else{
            array[rb] =   ra;
            sz[ra] += sz[rb];
        }
    }

    public void printArry(){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("arry[%d] = %d \n",i, array[i]);
            System.out.printf("size of %d is %d \n", i, sz[i]);
        }
    }


    public static void runWeightedQuickUnionUF(){


        WeightedQuickUnionUF weightUF = new WeightedQuickUnionUF(10);

        boolean result = weightUF.connected(0,3);
        System.out.println(" is Connected 0, 3 "+result);
        weightUF.union(0,2);
        System.out.println(" union 0, 2 ");
        weightUF.union(0,9);
        System.out.println(" union 0, 9 ");
        weightUF.union(3,9);
        System.out.println(" union 3, 9 ");

        weightUF.union(4,5);
        System.out.println(" union 4, 5 ");
        weightUF.union(1,8);
        System.out.println(" union 1, 8 ");
        weightUF.union(1,6);
        System.out.println(" union 1, 6 ");

        System.out.println(" is Connected 0, 3 "+weightUF.connected(0,3));
        System.out.println(" is Connected 2, 9 "+weightUF.connected(2,9));
        System.out.println(" is Connected 9, 0 "+weightUF.connected(9,0));


        weightUF.printArry();

    }
}
