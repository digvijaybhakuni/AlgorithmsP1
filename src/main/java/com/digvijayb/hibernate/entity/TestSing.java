package com.digvijayb.hibernate.entity;

/**
 * Created by digvijayb on 29/3/15.
 */
public class TestSing {
    private static TestSing ourInstance = new TestSing();

    public static TestSing getInstance() {
        return ourInstance;
    }

    private TestSing() {
    }
}
