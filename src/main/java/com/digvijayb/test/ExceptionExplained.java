package com.digvijayb.test;

/**
 * Created by digvijayb on 16/07/16.
 */
public class ExceptionExplained {


    public static void main(String... args){

        int val = doCallException();

        System.out.println(val);

    }

    private static int doCallException() {

        try{
            doExe();
            return 2;
        }catch (Exception ex){
            System.out.println("caugth");
            throw new RuntimeException("");
            //return 3;
        }finally {
            System.out.println("finally");
            return 4;
        }

    }


    private static int doExe() throws Exception {
        throw new Exception("");
    }





}
