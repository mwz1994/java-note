package erge_java;

import java.util.concurrent.*;

public class CallableDemo {
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        callableDemo.runDemo();
    }

    private void runDemo() throws ExecutionException, InterruptedException {
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello from thread "+ Thread.currentThread().getName();
            }
        };

        Future[] futures = new Future[10];

        for (int i =0;i<10; i++){
            futures[i] = executorService.submit(task);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println( futures[i].get() );
        }

        executorService.close();
    }
}
