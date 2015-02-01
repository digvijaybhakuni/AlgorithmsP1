package com.digvijayb.aglorithms.p1;

/**
 * Created by digvijayb on 1/2/15.
 */
public class QuickUnionUF {

    private int[] array = null;

    public QuickUnionUF(int lenght) {
        array = new int[lenght];
        for (int i = 0; i < lenght; i++){
            array[i] = i;
        }
    }

    private int root(int i){
        while (i!=array[i]){
            i=array[i];
        }
        return i;
    }

    public boolean connected(int a, int b){
        return (root(a)==root(b));
    }

    public void union(int a, int b){
       int ra = root(a);
       int rb = root(b);
       array[ra] = rb;
    }

    public void printArry(){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("arry[%d] = %d \n",i, array[i]);
        }
    }




    public static void runQuickUnionUF(){


        QuickUnionUF unionUF = new QuickUnionUF(10);

        boolean result = unionUF.connected(0,3);
        System.out.println(" is Connected 0, 3 "+result);
        unionUF.union(0,2);
        System.out.println(" union 0, 2 ");
        unionUF.union(0,9);
        System.out.println(" union 0, 9 ");
        unionUF.union(3,9);
        System.out.println(" union 3, 9 ");

        unionUF.union(4,5);
        System.out.println(" union 3, 9 ");
        unionUF.union(1,8);
        System.out.println(" union 3, 9 ");
        unionUF.union(1,6);
        System.out.println(" union 3, 9 ");

        System.out.println(" is Connected 0, 3 "+unionUF.connected(0,3));
        System.out.println(" is Connected 2, 9 "+unionUF.connected(2,9));
        System.out.println(" is Connected 9, 0 "+unionUF.connected(9,0));


        unionUF.printArry();

    }

}
