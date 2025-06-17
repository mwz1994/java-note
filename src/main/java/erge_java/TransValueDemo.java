package erge_java;

public class TransValueDemo {
    public static void main(String[] args) {
        int age = 18;
        modify(age);
        System.out.println(age);
    }

    private static void modify(int age1) {
        age1 = 30;
    }
}

class ReferenceTypeDemo {
    public static void main(String[] args) {
        String name = "二哥";
        modify(name);
        System.out.println(name);
    }

    private static void modify(String name1) {
        name1 = "三妹";
    }
}

class ThreadPriority{
    public static void main(String[] args) {
        // 创建一个线程组
        ThreadGroup group = new ThreadGroup("testGroup");
// 将线程组的优先级指定为 7
        group.setMaxPriority(7);
// 创建一个线程，将该线程加入到 group 中
        Thread thread = new Thread(group, "test-thread");
// 企图将线程的优先级设定为 10
        thread.setPriority(5);
// 输出线程组的优先级和线程的优先级
        System.out.println("线程组的优先级是：" + group.getMaxPriority());
        System.out.println("线程的优先级是：" + thread.getPriority());
    }
}
