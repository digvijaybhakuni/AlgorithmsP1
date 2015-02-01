package com.digvijayb.aglorithms.ds;

/**
 * Created by digvijayb on 1/2/15.
 */
public class SingleLinkedList<T> {

    private class Node<T>{
        T value;
        Node next;
    }

    private Node<T> first = null;
    private Node<T> last = null;
    private int size = 0;

    public void add(T value){
        Node<T> newNode = addIt(value);
        if(first==null){
            first = newNode;
            last = first;
        }else{
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void addFirst(T value){
        Node<T> newNode = addIt(value);
        if(first==null){
            first = newNode;
            last = first;
        }else{
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    /**
     * Remove frist
     */
    public T remove(){
            try {
                return (first!=null)? first.value : null;
            }finally {
                first = first.next;
                size--;
            }


    }

    public T removeLast(){
        Node<T> node = first;
        try {
            while(size > 0 && node!=null){
                if (node.next == last || last==node) {
                    return last.value;
                }
                node = node.next;
            }
            return null;
        }finally {
            last = node;
            size--;
        }
    }


    private Node<T> addIt(T value){
        Node<T>  node = new Node<T>();
        node.next = null;
        node.value = value;
        return node;
    }

    public int getSize(){
        return this.size;
    }

    public void print(){
        Node<T> node = first;
        while (node != null){
            System.out.println(node.value);
            node= node.next;
        }
    }
}
