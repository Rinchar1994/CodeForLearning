package main.java;

import java.util.Date;

/**
 * Created by Rinchar on 2018/4/27.
 */
interface State {
    public void eat();
}

class N implements State {
    @Override
    public void eat() {
        System.out.println("1");
    }
}

class H implements State {
    @Override
    public void eat() {
        System.out.println("3");
    }
}

class F implements State {
    @Override
    public void eat() {
        System.out.println("baole");
    }
}

class Someone {
    private State state;

    public Someone(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void eat() {
        state.eat();
    }
}

public class Test{
    public static void main(String[] args) {
        String[] strings = {"google", "applelppa", "bananaab"};
        for (String each : strings) {
            int le = Lon(each);
            System.out.println(le);
        }
    }

    public static int Lon(String strings) {
        if (strings == null || strings.length() == 0) {
            return -1;
        }
        int symLen = 1;
        char[] letter = strings.toCharArray();
        int strLen = strings.length();
        int currIndex = 1;
        while (currIndex > 0 && currIndex < strLen - 1) {
            int temp = 1;
            for(int i = 1; i <= currIndex && i <= strLen - currIndex; i++) {
                if (letter[currIndex - i] == letter[currIndex + i]) {
                    temp += 2;
                } else break;
            }
            symLen = symLen >= temp ? symLen : temp;
        }
        return symLen;
    }
}
