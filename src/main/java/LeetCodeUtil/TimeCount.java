package main.java.LeetCodeUtil;

import java.util.concurrent.TimeUnit;

/**
 * Created by Rinchar on 2017/11/8.
 */
public class TimeCount {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        TimeCount.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + TimeCount.end() + " mills");
    }
}
