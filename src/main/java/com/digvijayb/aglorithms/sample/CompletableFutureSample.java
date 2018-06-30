package com.digvijayb.aglorithms.sample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;


public class CompletableFutureSample {


    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<Integer> future = create(3);

        // Handle Take BiFunction data (Integer for this case) from Future and throwable in case error
        future.handle((data, err) -> {
            System.out.println("handle");
            if (err != null) {
                return data.toString();
            }
            err.printStackTrace(System.out);
            return "Error";
        });
        // Will not change state within future (will reciver Integer value 3)
        future.thenApply(e -> e * e)
                .thenAccept(data -> System.out.println("data = " + data))
                .thenRun(() -> System.out.println(" Future Complated "));

        // Will not change state within future (will reciver Integer value 3)
        future.thenApply(e -> e * -1)
                .thenAccept(System.out::println);

        // Exception handling
        future
                .thenApply(e -> {
                    if (e < 10) {
                        throw new RuntimeException("Exception Happened ");
                    }
                    return e;
                })
                .exceptionally(err -> {
                    System.out.println("err.getMessage() = " + err.getMessage());
                    return 111;
                })
                .thenAccept(e -> System.out.println("Accept e = " + e))
                .exceptionally(err -> { throw new RuntimeException("Error to end "+ err.getMessage()); });


        // Combine two future, pipe before thenCombine will be effective on future one only
        // the BiFunction in thenCombine while reciver the modify result in r1 by the pipe line before it
        future.thenApply(e -> -1).thenCombine(create(1), (r1, r2) -> {
            return r1 + r2;
        }).thenApply(e -> e * 2).handle((data, err)-> {
            System.out.println("data = " + data);
            System.out.println("err = " + err);
            return data;
        });

        // Compose want map (or apply change to result) with another future
        // like return of first future is input for second future (common like known as switch map)
        future.thenCompose(e -> zeroIt(e))
                .thenAccept(System.out::print)
                .thenRun(() -> System.out.println(" We made it zero"));

        sleep(1000);
        // After This sleep 2 sec Future will get completed with value of 2 by following method
        // which means handler and other callback will receive 2 as value
        future.complete(2);
        System.out.println("End of Main");
        sleep(3000);
    }

    private static CompletionStage<Integer> zeroIt(Integer e) {
        return create(e * 0);
    }

    private static CompletableFuture<Integer> create(int value) {
        System.out.println("Creating Future");
        //return CompletableFuture.completedFuture(value);
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread : " + Thread.currentThread());
            sleep(2000);
            return value;
        });
    }

    private static CompletableFuture<Integer> create(Supplier<Integer> supplier){
        return CompletableFuture.supplyAsync(supplier);
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
