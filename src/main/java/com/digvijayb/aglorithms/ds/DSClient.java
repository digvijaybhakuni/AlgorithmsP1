package com.digvijayb.aglorithms.ds;

/**
 * Created by digvijayb on 1/2/15.
 */
public class DSClient {

    public static void main(String... args){

            //DSClient.clientToSingleLinkedList();
            DSClient.clientToDoubleLinkedList();
    }

    private static void clientToSingleLinkedList(){
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        for(int i = 0; i < 4; i++){
            linkedList.addFirst(i);
        }
        System.out.println("list size = [" + linkedList.getSize() + "]");
        linkedList.print();
        Integer get = null;
        get = linkedList.removeLast();
        while (get != null){
            System.out.println("get = [" + get + "]");
            get = linkedList.removeLast();
        }

    }

    private static void clientToDoubleLinkedList(){
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<Integer>();

        for(int i = 0; i < 4; i++){
            linkedList.add(i);
        }
        System.out.println("list size = [" + linkedList.getSize() + "]");
        linkedList.print();
        Integer get = null;
        get = linkedList.remove();
        while (get != null){
            System.out.println("get = [" + get + "]");
            get = linkedList.remove();
        }

    }

}
