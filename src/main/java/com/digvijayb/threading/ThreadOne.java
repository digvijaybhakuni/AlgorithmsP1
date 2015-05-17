package com.digvijayb.threading;

/**
 * Created by digvijayb on 9/5/15.
 */
public class ThreadOne {

    public static void main(String... args) throws InterruptedException{
        final Thread main = Thread.currentThread();
        Thread  thread;
        thread = new Thread(()->{
            System.out.println("Lets Wait to main thread to terminate");

            try {
                System.out.println("Going for 1 sleep");
                Thread.sleep(9);
                System.out.println("Woke up for 1 sleep");
                System.out.println(main.getState());
                Thread.sleep(9000);
                System.out.println(main.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        /*
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Lets Wait to main thread to terminate");

                try {
                    System.out.println("Going for 1 sleep");
                    Thread.sleep(9);
                    System.out.println("Woke up for 1 sleep");
                    System.out.println(main.getState());
                    Thread.sleep(9000);
                    System.out.println(main.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/

        thread.setDaemon(true);
        System.out.println(main.getThreadGroup().getName()+" : GN Main");
        System.out.println(thread.getThreadGroup().getName()+" : GN thread");

        System.out.println(main.isDaemon()+" : Daemon Main");
        System.out.println(thread.isDaemon()+" : Daemon thread");

        thread.start();
        System.out.println("Exiting");
        Thread.sleep(20);
        System.out.println(main.getState());


    }


}
