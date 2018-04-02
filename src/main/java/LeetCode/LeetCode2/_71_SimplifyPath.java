package main.java.LeetCode.LeetCode2;

import java.util.Stack;

/**
 * Created by Rinchar on 2017/11/9.
 */
public class _71_SimplifyPath {
    //71. Simplify Path (Medium) 49.53%
    public static String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        Stack<String> reStack = new Stack<>();
        for (String str : pathArr) {
            if (str.length() == 0) continue;
            if (str.equals("..")) {
                if (!reStack.empty()) {
                    reStack.pop();
                }
            } else if (str.equals(".")) continue;
            else reStack.push(str);
        }
        String reStr = "";
        while (!reStack.empty()) {
            reStr = "/" + reStack.peek() + reStr;
            reStack.pop();
        }
        return reStr.length() == 0 ? "/" : reStr;
    }

    public static void main(String[] args) {
        String path = "/a/./b//../../c/";
        System.out.println(simplifyPath(path));
    }
}
