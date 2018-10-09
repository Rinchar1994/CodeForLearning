package main.java.BiShi;

import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/9/20
 **/
public class Unix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();

        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "/";
        char[] chars = path.toCharArray();
        int s = 0;
        int f = 1;

        while (f < chars.length) {
            if (chars[f] != '/') {
                int prevPos = f;
                while (f < chars.length && chars[f] != '/') {
                    f++;
                }
                if (f - prevPos == 2 && chars[prevPos] == '.' && chars[prevPos + 1] == '.') {
                    if (s != 0) {
                        s--;
                    }
                    while (chars[s] != '/') {
                        s--;
                    }
                } else if (f - prevPos != 1 || chars[prevPos] != '.'){
                    for (int i = prevPos; i < f; i++) {
                        chars[++s] = chars[i];
                    }
                }
            } else if (chars[s] != '/') {
                chars[++s] = '/';
                f++;
            } else {
                f++;
            }
        }
        if (s != 0 && chars[s] == '/' ) {
            s--;
        }
        return new String(chars, 0, s + 1);
    }
}
