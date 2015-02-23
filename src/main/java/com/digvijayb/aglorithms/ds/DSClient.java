package com.digvijayb.aglorithms.ds;

import com.digvijayb.aglorithms.p1.Shuffling;

/**
 * Created by digvijayb on 1/2/15.
 */
public class DSClient {

    public static void main(String... args){

            //DSClient.clientToSingleLinkedList();
            //DSClient.clientToDoubleLinkedList();
            DSClient.clientToDemoBST();
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

    private static void clientToDemoBST(){

        int a[] = new int[20];
        Shuffling.initRandom();
        for(int i = 0; i < a.length ; i++){
            a[i] = i*Shuffling.uniform(20)*3;
        }

        a = Shuffling.shuffle(a);
        //a = Shuffling.shuffle(a);
        //a = Shuffling.shuffle(a);
        BinarySearchTree<Integer,String> integerStringBinarySearchTree = new BinarySearchTree<Integer, String>();
        for(int i : a){
            System.out.println(i);
            integerStringBinarySearchTree.put(i,String.valueOf(i));
        }

        System.out.println("--------------------------------------");
        System.out.println(integerStringBinarySearchTree.get(a[9]));
        System.out.println(integerStringBinarySearchTree.get(a[4]));
        System.out.println(integerStringBinarySearchTree.get(a[6]));
        System.out.println(integerStringBinarySearchTree.get(a[3]));
    }


}
