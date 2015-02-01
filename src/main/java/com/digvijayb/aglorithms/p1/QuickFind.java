package com.digvijayb.aglorithms.p1;

/**
 * Created by digvijayb on 31/1/15.
 */
public class QuickFind {

    private int array[] = null;

    /**
     * Create object on QuickFind
     * O(n);
     * @param lenght
     */
    public QuickFind(int lenght){

        array = new int[lenght];
        for (int i = 0; i < lenght; i++){
            array[i] = i;
        }

    }

    /**
     * Tell if a is connected to b
     * O(1)
     * @param a
     * @param b
     * @return
     */
    public boolean connected(int a, int b){
        return (array[a] == array[b]);
    }

    /**
     * Join or connect a and b
     * @param a
     * @param b
     */
    public void union(int a, int b){
        int aid = array[a];
        int bid = array[b];
        for(int i = 0; i < array.length; i++){
            if(aid == array[i]){
                array[i] = bid;
            }
        }
    }

    public void printArry(){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("arry[%d] = %d \n",i, array[i]);
        }
    }




    public static void runQuickFind(){


        QuickFind quickFind = new QuickFind(10);

        boolean result = quickFind.connected(0,3);
        System.out.println(" is Connected 0, 3 "+result);
        quickFind.union(0,2);
        System.out.println(" union 0, 2 ");
        quickFind.union(0,9);
        System.out.println(" union 0, 9 ");
        quickFind.union(3,9);
        System.out.println(" union 3, 9 ");

        quickFind.union(4,5);
        System.out.println(" union 3, 9 ");
        quickFind.union(1,8);
        System.out.println(" union 3, 9 ");
        quickFind.union(1,6);
        System.out.println(" union 3, 9 ");

        System.out.println(" is Connected 0, 3 "+quickFind.connected(0,3));
        System.out.println(" is Connected 2, 9 "+quickFind.connected(2,9));
        System.out.println(" is Connected 9, 0 "+quickFind.connected(9,0));


        quickFind.printArry();

    }

}
