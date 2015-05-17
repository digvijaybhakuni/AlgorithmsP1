package com.digvijayb.threading;

/**
 * Created by digvijayb on 17/5/15.
 */
public class ThreadRunnerClass {
    public static void main(String[] args) {
        whenPerInstance();
        //whenOneInstance();
    }

    public static void whenPerInstance(){
        ShareObjectOne s1 = new ShareObjectOne();
        ShareObjectOne s2 = new ShareObjectOne();

        //new Thread(new MyRunnable(s1), "[Super Hero S1]").start();
        //new Thread(new MyRunnable(s2), "[Super Hero S2]").start();
        //new Thread(new MyRunnable(null), "[Super Hero S3]").start();
        //new Thread(new MyRunnable(null), "[Super Hero S4]").start();

        new Thread(new MyRunnable(null), "[Super Hero S5]").start();
        new Thread(new MyRunnable(null), "[Super Hero S6]").start();

    }

    public static void whenOneInstance(){
        ShareObjectOne s = new ShareObjectOne();

        new Thread(new MyRunnable(s), "[Super Hero S1]").start();
        new Thread(new MyRunnable(s), "[Super Hero S2]").start();
    }

    public static class MyRunnable implements Runnable{

        ShareObjectOne s;

        MyRunnable(ShareObjectOne s){
            this.s = s;
        }

        public void run(){
            try {
                System.out.println(Thread.currentThread().getName() + " started");

                if ("[Super Hero S3]".equalsIgnoreCase(Thread.currentThread().getName())) {
                    ShareObjectOne.staticEntryMethod(1, 9);
                } else if ("[Super Hero S4]".equalsIgnoreCase(Thread.currentThread().getName())) {
                    ShareObjectOne.staticSynMethod2(0, 12);
                } else if ("[Super Hero S5]".equalsIgnoreCase(Thread.currentThread().getName())) {
                    //MyStaticClas.runnerStatic(9000);
                    MyStaticClas.synBlockRunner(9000);
                } else if ("[Super Hero S6]".equalsIgnoreCase(Thread.currentThread().getName())) {
                    MyStaticClas.runnerStaticNS2(2000);
                    MyStaticClas.runnerStatic2(1000);
                } else {
                    s.entryMethod();
                }
			/*
			int s = getIntEnsure(Thread.currentThread().getName().hashCode(),5);
            int e = getIntEnsure(Thread.currentThread().getName().hashCode(),10);
            System.out.println(s + " : "+e);
            ShareObjectOne.staticEntryMethod(s, e);
            */

            }catch (InterruptedException ex){
                ex.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + " end");
            }
        }


        private int getIntEnsure(int value, int limit){
            return (value & (limit -1))+5;
        }

    }
}

class ShareObjectOne {

    /**
     *
     */
    public ShareObjectOne() {
        opiThread = Thread.currentThread().getName();
    }

    public static volatile String opsThread= null;
    public volatile String opiThread= null;


    public void entryMethod(){
        opiThread = Thread.currentThread().getName();
        System.out.println("ENTRING Thread : "+opiThread);
        try {
            synMethod();
        } catch (InterruptedException e) {
            System.out.printf("%s thread ki laggai ", opiThread);
            e.printStackTrace();
        }
        System.out.println("EXITING Thread : "+opiThread);
    }

    public synchronized void synMethod() throws InterruptedException{
        opsThread = Thread.currentThread().getName();
        for(int i =0 ; i < 20; i++){
            System.out.printf("%s : %d : %s \n", opiThread , i , opsThread);
            if("[Super Hero S1]".equals(opiThread)){
                opsThread = Thread.currentThread().getName();
                if(i%5==0){
                    mywait(500);
                }else{
                    Thread.sleep(100);
                }
            }else{
                opsThread = Thread.currentThread().getName();
                if(i%5==0){
                    mywait(100);
                }else{
                    Thread.sleep(500);
                }

            }
        }
    }

    public static void staticEntryMethod(int s, int e){
        System.out.println("ENTRING Thread : "+Thread.currentThread().getName());
        try {
            staticSynMethod(s, e);
        } catch (InterruptedException ex) {
            System.out.printf("%s thread ki laggai ", Thread.currentThread().getName());
            ex.printStackTrace();
        }
        System.out.println("EXITING Thread : "+Thread.currentThread().getName());
    }

    public synchronized static void staticSynMethod(int s, int e) throws InterruptedException{
        int ctr = 0;
        opsThread = Thread.currentThread().getName();
        for(int i = s; i < e; i++){
            ctr++;
            if("[Super Hero S1]".equals(opsThread) ){
                opsThread = Thread.currentThread().getName();
                Thread.sleep(500);
                MyStaticClas.runnerStatic(200);
            }else{
                opsThread = Thread.currentThread().getName();
                Thread.sleep(100);
                MyStaticClas.runnerStatic(300);
            }
        }
        System.out.println(ctr+" COUNTER MIL GAYA");
    }

    public synchronized static void staticSynMethod2(int s, int e){
        opsThread = Thread.currentThread().getName();
        for(int i = s; i < e; i++){
            System.out.println(opsThread + " : " + i);
        }
    }


    public void mywait(int time) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" : Waiting for "+time);
        wait(time);
    }

    public void mywait() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " : Waiting");
        wait();
    }


}

class MyStaticClas {

    private static Integer anInt = 90;

    public static synchronized void runnerStatic(int sleepTime) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+ " is going to sleep runnerStatic ");
        Thread.sleep(sleepTime);
        System.out.println(Thread.currentThread().getName()+ " is going to wake up runnerStatic ");
    }

    public static synchronized void runnerStatic2(int sleepTime) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+ " is going to sleep runnerStatic2");
        Thread.sleep(sleepTime);
        System.out.println(Thread.currentThread().getName()+ " is going to wake up  runnerStatic2");
    }

    public static void synBlockRunner(int sleepTime) throws InterruptedException{
        synchronized (anInt){
            System.out.println(Thread.currentThread().getName()+ " is going to sleep synBlockRunner");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " is going to wake up  synBlockRunner");
            System.out.println(Thread.currentThread().getName()+ " is going to runnerStaticNS2 From synBlock");
            runnerStaticNS2(sleepTime);
            System.out.println(Thread.currentThread().getName() + " is came out from  runnerStaticNS2 in synBlock");
        }
    }

    public  static void runnerStaticNS2(int sleepTime) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+ " is going to sleep runnerStaticNS2");
        Thread.sleep(sleepTime);
        System.out.println(Thread.currentThread().getName()+ " is going to wake up runnerStaticNS2");
    }


}

