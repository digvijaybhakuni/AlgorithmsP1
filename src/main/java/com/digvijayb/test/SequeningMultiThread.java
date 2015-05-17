package com.digvijayb.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by digvijayb on 18/4/15.
 */
public class SequeningMultiThread {

    public static void main(String[] args) {
        try {
            runner(2,4);
            runner2(5,4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public static void runner(final int noThread,final int limit) throws InterruptedException, ExecutionException {

        class MyJob implements Callable<Integer>{

            private int no;
            private int index = 0 ;

            public MyJob(int no){
                this.no = no;
            }

            public Integer call() throws Exception {
                return getValueFromS(no, index++);
            }
        }

        List<MyJob> myJobs = new ArrayList();
        for(int i =0 ; i < noThread; i++){
            myJobs.add(new MyJob(i));
        }
        List<Integer> value = new ArrayList<Integer>();

        ExecutorService executorService = Executors.newFixedThreadPool(noThread);
        for(int i = 0; i < limit; i++) {
            for (Future<Integer> future : executorService.invokeAll(myJobs)) {
                value.add(future.get());
            }
        }

        System.out.println(value);
        executorService.shutdown();

    }


    public static void runner2(final int noThread,final int limit){

        List<List<Integer>> seriseOfSerise = new ArrayList<List<Integer>>(noThread);
        List<Integer> serise = null;
        for(int i = 0; i < noThread; i++){
            serise = new ArrayList<Integer>(limit);
            for (int j = 0; j < limit; j++){
                serise.add(getValueFromS(i,j));
            }
            seriseOfSerise.add(serise);
        }

        System.out.println(seriseOfSerise.size() + " size ");

        class MyPrintTask implements Runnable{

            List<Integer> integers = null;
            public MyPrintTask(List<Integer> integers){
                this.integers = integers;
            }

            int index = 0;

            @Override
            public void run() {
                System.out.print(integers.get(index++));
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(noThread);

        //List<MyPrintTask> myJobs = new ArrayList();
        for(int i =0 ; i < noThread; i++){
            //myJobs.add(new MyPrintTask(seriseOfSerise.get(i)));
            executorService.execute(new MyPrintTask(seriseOfSerise.get(i)));
        }

        /*for(int i = 0; i < limit; i++) {
            executorService..
        }*/

        executorService.shutdown();
    }

    public static int getValueFromS(int no, int index){
        return (no)  + (4*index);
    }
}
