package com.digvijayb.aglorithms.sample;

import com.mongodb.BasicDBList;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by digvijayb on 18/06/17.
 */
public class LambdaCollectTest {

    public static void main(String[] args) {


        final Stream<String> stringStream = Arrays.stream(new String[]{"Digvijay", "Singh", "Bhakuni", "a", "b", "c", "d", "e", "f"});


        final BasicDBList basicDBList = stringStream.parallel().collect(BasicDBList::new, BasicDBList::add, BasicDBList::addAll);


        System.out.println("basicDBList = " + basicDBList);

    }


    private BasicDBList join(BasicDBList basicDBList){

        final BasicDBList objects = new BasicDBList();
        objects.addAll(basicDBList);
        return null;
    }

}
