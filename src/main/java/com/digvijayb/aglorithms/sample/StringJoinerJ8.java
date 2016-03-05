package com.digvijayb.aglorithms.sample;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by digvijayb on 2/20/2016.
 */
public class StringJoinerJ8 {

    public static void main(String... args){


        testStringJoiner1();
        testStringJoiner2();

        testString_join();

        testString_Collection_Stream_Join();

        testString_On_POJO_Collection_Stream_Join();

    }

    static void testStringJoiner1(){

        StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString(); //aaa,bbb,ccc

        System.out.println(result);
    }

    static void testStringJoiner2(){

        StringJoiner sj = new StringJoiner("/", "prefix-", "-suffix");
        sj.add("2016");
        sj.add("02");
        sj.add("26");
        String result = sj.toString(); //prefix-2016/02/26-suffix

        System.out.println(result);
    }

    static void testString_join(){

        String result = String.join("#", "Digvijay","Bhakuni");

        System.out.println(result); //Digviajy#Bhakuni

        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
        //java| python| nodejs| ruby
        String result_list = String.join("|", list);

        System.out.println(result_list);
    }

    static void testString_Collection_Stream_Join(){

        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");

        //java / python / nodejs / ruby
        String result = list.stream().map(x -> x).collect(Collectors.joining(" / "));

        System.out.println(result);

    }


    static void testString_On_POJO_Collection_Stream_Join(){

        class Game{
            String name;
            int ranking;

            public Game(String name, int ranking) {
                this.name = name;
                this.ranking = ranking;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getRanking() {
                return ranking;
            }

            public void setRanking(int ranking) {
                this.ranking = ranking;
            }

            @Override
            public String toString() {
                return String.format("{ name : %s , rank : %s }", this.getName(), this.getRanking());
            }
        }


        List<Game> list = Arrays.asList(
                new Game("Counter Strike", 1),
                new Game("Age of Empire", 2),
                new Game("NFS Most Wanted",4)
        );

        String result = list.stream().map(x -> x.toString()).collect(Collectors.joining(",","[","]"));

        System.out.println(result);

    }

}
