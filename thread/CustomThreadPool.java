package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CustomThreadPool {
    private final int nThreads;
    private final PoolWorker[] threads;
    private final BlockingQueue<Runnable> taskQueue;

    public CustomThreadPool(int nThreads) {
        this.nThreads = nThreads;
        taskQueue = new LinkedBlockingQueue<>();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    public void shutdown() throws InterruptedException {

        for (int i = 0; i < nThreads; i++) {
            taskQueue.put(() -> {}); // 空任务作为 Poison Pill
        }

        for (PoolWorker worker : threads) {
            worker.join();
        }
    }

    private class PoolWorker extends Thread {
        private volatile boolean running = true;

        public void stopWorker() {
            running = false;
        }

        @Override
        public void run() {
            while (running) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    // Restore interrupted status
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool pool = new CustomThreadPool(2);

        for (int i = 0; i < 5; i++) {
            int taskId = i;
            pool.execute(() -> {
                System.out.println("Task " + taskId + " by " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


//        sleep(10*1000);
        pool.shutdown();
    }
}
