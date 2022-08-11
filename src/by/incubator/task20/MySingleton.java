package by.incubator.task20;

public class MySingleton {
    int a;
    int b;
    int c;

    private volatile static MySingleton mySingleton;

    private MySingleton() {
        a = 1;
        b = 2;
        c = 3;
    }

    public static MySingleton instance() {
        if (mySingleton == null) {
            synchronized (MySingleton.class) {
                if (mySingleton == null) {
                    mySingleton = new MySingleton();
                }
            }
        }
        return mySingleton;
    }

    @Override
    public String toString() {
        return "a = " + a + ", " + "b = " + b + ", " + "c = " + c + ", " + "hash = " + hashCode();
    }
}