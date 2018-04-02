package main.java.NowCoder.NowCoderCode;

/**
 * Created by Rinchar on 2018/3/9.
 */
public class _8_JumpFloor {
    public static int JumpFloor(int target) {
        if(target <= 2) return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }
}
