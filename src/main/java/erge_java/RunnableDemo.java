package erge_java;

import java.util.concurrent.*;

public class RunnableDemo {
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunnableDemo callableDemo = new RunnableDemo();
        callableDemo.runDemo();
    }

    private void runDemo() throws ExecutionException, InterruptedException {
        Runnable task = () -> System.out.println("hello from thread "+ Thread.currentThread().getName());

        for (int i =0;i<10; i++){
            executorService.submit(task);
        }

        executorService.close();
    }
}
