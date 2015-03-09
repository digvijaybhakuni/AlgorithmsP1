package com.digvijayb.aglorithms.pattern.creation;

/**
 * Created by digvijayb on 9/3/15.
 */
public class ClientCB {


    public static  void main(String... args){

        builderClient();

    }


    public static void builderClient(){
        /**
         * Some Code
         */
        Product.Builder builder = new Product.Builder("iPhone5", "iPhone 5C", 499.90);//fill in the required field
        builder.brand("apple").maxRetialPrice(699.99);//chaining is done as it return itself
        Product iPhone = builder.build(); // building the immutable object of product iphone
        /**
         * Some Code that use iPhone object
         */
    }

}
