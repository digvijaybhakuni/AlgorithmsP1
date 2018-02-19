package com.digvijayb.aglorithms.pattern.creation;

public class UsingSingleton {

    public static void main(String[] args) {

        final SingletonOne singletonOne = SingletonOne.getInstance();

        final SingletonTwo singletonTwo = SingletonTwo.getInstance();

        System.out.println("singletonOne = " + singletonOne);
        System.out.println("singletonTwo = " + singletonTwo);

    }

}
