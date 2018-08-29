package main.java.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Rinchar
 * @date: 2018/8/28
 **/
public class ComparableTest implements Comparable{

    int key;
    int value;

    public ComparableTest(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        ComparableTest test = (ComparableTest) o;
        return this.key - test.key;
    }
}

class Main{
    public static void main(String[] args) {
        List<ComparableTest> comparableTests = new ArrayList<>();
        comparableTests.add(new ComparableTest(2, 2));
        comparableTests.add(new ComparableTest(1, 3));
        comparableTests.forEach(x -> System.out.println(x.key));
        comparableTests.sort(ComparableTest::compareTo);
        comparableTests.forEach(x -> System.out.println(x.key));
    }
}