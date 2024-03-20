package java8.completablefuture.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class OddEvenPrinter {

    public static void main(String[] args) {

        ExecutorService executorServiceOdd = Executors.newFixedThreadPool(1);
        ExecutorService executorServiceEven = Executors.newFixedThreadPool(1);

        CompletableFuture<Void> completableFutureOdd = CompletableFuture.runAsync(() -> printOddNumbers(), executorServiceOdd);
        CompletableFuture<Void> completableFutureEven = CompletableFuture.runAsync(() -> printEveNumbers(), executorServiceEven);
        CompletableFuture<Void> finalResult = CompletableFuture.allOf(completableFutureEven, completableFutureOdd);
        finalResult.join();

    }


    // want this task to be executed by one thread from my custom pool 1
    public static void printOddNumbers() {
        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    if (i % 2 != 0) {
                        System.out.println("Thread name is " + Thread.currentThread().getName() + " " + i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }

    // want this task to be executed by different thread from my custom pool 2
    private static void printEveNumbers() {
        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    if (i % 2 == 0) {
                        System.out.println("Thread name is " + Thread.currentThread().getName() + " " + i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }
}
