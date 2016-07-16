package com.digvijayb.spring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by digvijayb on 16/07/16.
 */
public class BeanA {

    private BeanB b;

    @Autowired
    public BeanA(BeanB b){
        this.b = b;
    }

    public BeanB getB() {
        return b;
    }
}
