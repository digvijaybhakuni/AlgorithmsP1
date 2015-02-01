package com.digvijayb.aglorithms.ds;

/**
 * Created by digvijayb on 1/2/15.
 */
public class DSClient {

    public static void main(String... args){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        for(int i = 0; i < 4; i++){
            linkedList.addFirst(i);
        }
        System.out.println("list size = [" + linkedList.getSize() + "]");
        linkedList.print();
        Integer get = null;
        do {
            get = linkedList.removeLast();
            System.out.println("get = [" + get + "]");
        }while (get != null);

    }

}
