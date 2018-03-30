package main.java;

/**
 * Created by Rinchar on 2018/3/29.
 */
public class A {
    public static int foo() {
        int i = 10;
        try {
            i = --i / 0;
            return i--;
        } catch (Exception e) {
            i = i--/0;
            return --i;
        }finally {
            --i;
            return i--;
        }
    }
    public static void main(String[] args) {
        System.out.println(foo());
    }

    public static void a() {
        
    }
}

