package com.digvijayb.aglorithms.ds;

/**
 * Created by digvijayb on 23/2/15.
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    Node root = null;

    private class Node{
        private K key;
        private V value;
        private Node left,right;
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value){
        root = put(root,key,value);
    }

    /**
     * We will add new node at left if less then root if greater then on right.
     * And if you have null root the put it in the root, if the key is already their then
     * we replace the value of the existing node
     *
     * @param parent
     * @param key
     * @param value
     * @return
     */
    public Node put(Node parent,K key, V value){
        if(parent == null ){
            return new Node(key,value);
        }
        int compare = key.compareTo(parent.key);
        if(compare > 0){
            parent.right = put(parent.right,key,value);
        }else if (compare < 0){
            parent.left = put(parent.left,key,value);
        }else if(compare == 0){
            parent.value = value;
        }
        return parent;
    }

    public void print(){



    }


    public V get(K key){
        return get(root,key);
    }

    private V get(Node parent,K key){
        if(parent==null){
            return null;
        }
        int compare = key.compareTo(parent.key);
        if(compare > 0){
            return get(parent.right,key);
        }else if (compare < 0){
            return get(parent.left,key);
        }else{
            return parent.value;
        }
    }
}
