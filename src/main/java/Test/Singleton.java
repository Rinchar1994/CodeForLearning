package main.java.Test;

/**
 * Created by Rinchar on 2018/4/27.
 */

public class Singleton {
    private Singleton() {
        System.out.println("hello" + System.currentTimeMillis());
    }

    private static class SingletonHolder{
        private final static Singleton SINGLETON = new Singleton();
    }

    public static final Singleton getSingleton() {
        return SingletonHolder.SINGLETON;
    }
}

class Temp{
    public static void main(String[] args) {
        Singleton.getSingleton();
        Singleton.getSingleton();
        Singleton.getSingleton();
    }
}
