package com.digvijayb.aglorithms.pattern.creation;

/**
 * Created by digvijayb on 9/3/15.
 */
//Builder Pattern
public class Product {

    private final String name;
    private final String description;
    private final String brand;
    private final double sellPrice;
    private final double costPrice;
    private final double maxRetialPrice;
    private final float discount;

    public static class Builder{
        //mandatory field
        private final String name;
        private final String description;
        private final double sellPrice;

        //option field
        private String brand = "";
        private double costPrice = 0.0;
        private double maxRetialPrice = 0.0;
        private float discount = 0.0F;

        public Builder(String name, String description, double sellPrice){
            this.name = name;
            this.description = description;
            this.sellPrice = sellPrice;
        }

        public Builder brand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder costPrice(double costPrice){
            this.costPrice = costPrice;
            return this;
        }
        public Builder maxRetialPrice(double maxRetialPrice){
            this.maxRetialPrice = maxRetialPrice;
            return this;
        }
        public Builder discount(float discount){
            this.discount = discount;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }


    private Product(Builder builder){
        this.name = builder.name;
        this.description = builder.description;
        this.brand = builder.brand;
        this.sellPrice = builder.sellPrice;
        this.costPrice = builder.costPrice;
        this.maxRetialPrice = builder.maxRetialPrice;
        this.discount = builder.discount;
    }

}
