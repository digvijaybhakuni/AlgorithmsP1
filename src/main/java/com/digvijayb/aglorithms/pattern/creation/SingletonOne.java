package com.digvijayb.aglorithms.pattern.creation;

/**
 * Created by digvijayb on 10/3/15.
 */
public final class SingletonOne {

    private SingletonOne(){
        super();
    }

    private static SingletonOne instance = null;

    public static synchronized SingletonOne getInstance(){
        if(instance == null){
            instance = new SingletonOne();
        }
        return instance;
    }

    /**
     * Some Other Code
     */
}
