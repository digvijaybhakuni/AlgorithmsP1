package com.digvijayb.aglorithms.ds;

/**
 * Created by digvijayb on 1/2/15.
 */
public class DoubleLinkedList<T> {

    private class Node<T>{
        T value;
        Node<T> next;
        Node<T> prev;
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
            newNode.prev = last;
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
            first.prev = newNode;
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
            if(first!=last) {
                first = first.next;
                first.prev = null;
            }else{
                first = null;
                last = null;
            }
            size--;
        }


    }

    public T removeLast(){
        try {
            return (last!=null)? last.value : null ;
        }finally {
            if(first!=last) {
                last = last.prev;
                last.next = null;
            }else{
                first = null;
                last = null;
            }
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

    public boolean isEmpty(){
        return (this.size<1);
    }

}
