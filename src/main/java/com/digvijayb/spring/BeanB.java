package com.digvijayb.spring;

/**
 * Created by digvijayb on 16/07/16.
 */
public class BeanB {


    private BeanA a;

    public BeanB(BeanA a){
        this.a = a;
    }

    public BeanA getA() {
        return a;
    }
}
