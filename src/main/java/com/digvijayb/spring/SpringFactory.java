package com.digvijayb.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by digvijayb on 16/07/16.
 */
public class SpringFactory {

    public static void main(String... args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");

        System.out.println("Spring context Created");

        BeanB beanB = context.getBean(BeanB.class);
        BeanA beanA = context.getBean(BeanA.class);

        System.out.println(beanA.toString());
        System.out.println(beanB.toString());

        System.out.println(beanA.getB().toString());
        System.out.println(beanB.getA().toString());

    }
}
