package main.java.NowCoder.NowCoderCode;

/**
 * Created by Rinchar on 2018/3/9.
 */
public class _8_JumpFloor {
    public static int JumpFloor(int target) {
        if(target <= 2) return target;
        int slow = 1, fast = 2, temp;
        for(int i = 3; i <= target; i++) {
            temp = fast;
            fast += slow;
            slow = temp;
        }
        return fast;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }
}
