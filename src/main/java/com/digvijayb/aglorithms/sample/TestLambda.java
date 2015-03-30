package com.digvijayb.aglorithms.sample;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by digvijayb on 28/3/15.
 */
public class TestLambda {

    interface OneInterface{ void myOneMothod();}
    interface TwoInterface{ int getSquare(int a);}
    interface ThreeInterface{ void myThreeMothod(int a, String b);}

    public static void main(String... args){
       /*
        String str = "Welcome to lambda expression ";

        OneInterface one = () -> System.out.println(str);
        int a = 5;
        TwoInterface two = ab -> ab*ab;
        ThreeInterface three;
        three = (ac, str1) -> {
            System.out.println(ac);
            int asq = ac*ac;
            String s = str1.substring(11);
            System.out.println(asq + " : "+s);
        };

        //Calling interfaces methods
        one.myOneMothod();
        two.getSquare(a);
        three.myThreeMothod(a+9,str);
        */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        list.forEach(n -> System.out.println(n));

        list.forEach(TestLambda::getMax);

        System.out.println("Max is "+ max);
        list.stream().filter(e -> e%2 == 0).forEach(e -> sum += e);
        System.out.println("Sum of even : " + sum);

        List<Person> persons = new ArrayList<Person>(){
            {
                add(new Person(24, "Digvijay", Person.Sex.MALE));
                add(new Person(24, "Meghna", Person.Sex.FEMALE));
                add(new Person(27, "Vikas", Person.Sex.MALE));
                add(new Person(27, "Neha", Person.Sex.FEMALE));
            }
        };


        ///Reduction Funtion
        double asDouble = persons.stream().filter(e -> e.getSex() == Person.Sex.MALE).peek(Person::printName).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println(asDouble);

        Integer sumOfAgeAllMale = persons.stream().filter(e -> e.getSex() == Person.Sex.MALE).peek(Person::printName).mapToInt(Person::getAge).sum();
        System.out.println("sumOfAgeAllMale = "+sumOfAgeAllMale);

        Integer totalAgeReduce;
        /* reduce: the first argument of the is always the left value for method passed and whatever the value is returned is now left value
         * link : https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
         * */
        totalAgeReduce = persons.stream().mapToInt(Person::getAge).reduce(0,(left,right)->{ return left-right; });//
        //totalAgeReduce = persons.stream().mapToInt(Person::getAge).reduce(10,TestLambda::abc);
        System.out.println("totalAgeReduce = " + totalAgeReduce);
        //.ifPresent(e -> System.out.println("e.getName() = " + e.getName()));

        // Collect function

        List<String> nameofAllMale = persons.stream().filter(e -> e.getSex() == Person.Sex.MALE).map(e -> e.getName()).collect(Collectors.toList());

        nameofAllMale.forEach(System.out::println);

        List<Person> malePerson = persons.stream().filter(e -> e.getSex() == Person.Sex.MALE).collect(Collectors.toList());

        // Now Grouping By age Collection

        Map<Integer, List<Person>> groupeByAgeOfPerson = persons.stream().collect(Collectors.groupingBy(Person::getAge));
        //e -> e.getAge()

        Map<Person.Sex, List<String>> collect = persons.stream().collect(Collectors.groupingBy(e -> e.getSex(), Collectors.mapping(e -> e.getName(), Collectors.toList())));

        Map<Person.Sex, List<String>> abc = persons.stream().collect(Collectors.groupingBy(e -> e.getSex(), Collectors.mapping(e -> e.getName(), Collectors.toList())));



        /*
         * https://docs.oracle.com/javase/tutorial/collections/TOC.html
         */

    }

    //This Method provide implementation to IntBinaryOperator:applyAsInt(int left, int right);
    public static  int abc(int left, int right){
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        System.out.println(right % left);
        return right % left;
    }

    public static class Person{

        public  enum Sex{ MALE, FEMALE }

        int age;
        String name;
        Sex sex;

        Person(int age, String name, Sex sex) {
            this.age = age;
            this.name = name;
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Sex getSex() {
            return sex;
        }

        public void setSex(Sex sex) {
            this.sex = sex;
        }

        public static void printName(Person person){
            System.out.println(person.getName());
        }
    }

    public static int max = 9;

    public static void getMax(int incoming){
        if(max < incoming){
            max = incoming;
        }
    }

    public static int sum = 0;

    public static void getSum(int incoming){
        sum += incoming;
    }

}
