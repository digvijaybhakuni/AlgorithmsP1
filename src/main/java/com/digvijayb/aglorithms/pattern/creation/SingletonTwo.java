package com.digvijayb.aglorithms.pattern.creation;

/**
 * Created by digvijayb on 10/3/15.
 */
public class SingletonTwo {

    private static SingletonTwo instance;

    private SingletonTwo(){

    }


    public static SingletonTwo getInstance(){
        if(instance == null){
            synchronized(SingletonTwo.class) {
                if(instance == null) {
                    instance = new SingletonTwo();
                }
            }
        }
        return instance;
    }


}
