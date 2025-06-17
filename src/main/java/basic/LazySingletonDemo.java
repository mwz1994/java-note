package basic;

public class LazySingletonDemo {
    private static LazySingletonDemo INSTANCE ;

    private LazySingletonDemo(){

    }

    public static synchronized LazySingletonDemo getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new LazySingletonDemo();
        }
        return INSTANCE;
    }
}
