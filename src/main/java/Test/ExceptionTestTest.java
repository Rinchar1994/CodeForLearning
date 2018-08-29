package main.java.Test;

/**
 * @author: Rinchar
 * @date: 2018/8/27
 **/
public class ExceptionTestTest {
    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (RuntimeException e) {
            System.out.println("This is RuntimeException");
        } catch (Exception e) {
            System.out.println("This is Exception");
        }
        try {
            Class c1 = new ExceptionTestTest().getClass();
            Class c2 = Class.forName("main.java.Test.ExceptionTestTest");
            Class c3 = ExceptionTestTest.class;
        } catch (Exception e) {
            System.out.println("Create Class Object Failed");
        }
    }
}
