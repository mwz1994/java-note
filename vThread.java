import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class vThread {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            Thread vThread = Thread.ofVirtual()
                    .start(() -> System.out.println(Thread.currentThread().getName() + " Hello World"));
        }

        // 主线程休眠 1 秒，等待虚拟线程执行
        Thread.sleep(1000);
    }
}

class ExecutorVThread{
    public static void main(String[] args) throws InterruptedException {

        var executor = Executors.newVirtualThreadPerTaskExecutor() ;

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> System.out.println(Thread.currentThread().threadId() + " Hello World"));
        }

        executor.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("All virtual threads are finished");
    }
}

//class SumOfNums {
//
//    static void sum() {
//        int a = 1, b = 2;
//        int sum = a + b;
//        System.out.println("Thread --> " + Thread.currentThread().getName() + " sum: "+sum);
//    }

//    public static void main(String[] args) {
//        for (int i = 1; i <= 12; i++) {
//            Thread t = new Thread(SumOfNums::sum);
//            t.start();
//        }
//    }
//}
