package concurrent_art;

public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) throws InterruptedException {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        System.out.println("-- get A lock");
                        Thread.currentThread().sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    synchronized (B){
                        System.out.println("-- get B lock");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (B){
                    System.out.println("== get B lock");
                    synchronized (A){
                        System.out.println("== get A lock");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
