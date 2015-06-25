package com.digvijayb.threading;

import java.util.Random;

/**
 * Created by digvijayb on 17/5/15.
 */
public class Deadlock implements Runnable {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();
    private final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Thread myThread1 = new Thread(new Deadlock(), "thread-1");
        Thread myThread2 = new Thread(new Deadlock(), "thread-2");
        myThread1.start();
        myThread2.start();
        int i = 0;
        while(true && i < 99){
            System.out.println(myThread1.getState() + "  " + myThread1.getName());
            System.out.println(myThread2.getState() + "  " + myThread2.getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            boolean b = random.nextBoolean();
            if (b) {
                System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 1.");
                synchronized (resource1) {
                    System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 1.");
                    System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 2.");
                    synchronized (resource2) {
                        System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
                    }
                }
            } else {
                System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 2.");
                synchronized (resource2) {
                    System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
                    System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 1.");
                    synchronized (resource1) {
                        System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 1.");
                    }
                }
            }
        }
    }
}