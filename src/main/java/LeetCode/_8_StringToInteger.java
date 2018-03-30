package main.java.LeetCode;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Rinchar on 2017/10/10.
 */
public class _8_StringToInteger {
    //8. String to Integer(atoi) (Medium)
    //完成度很差
    public static int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        String[] space = str.split(" ");
        for (String str_sub : space) {
            if (str_sub.length() > 0) {
                str = str_sub;
                break;
            }
        }
        if (str.length() == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
            return 0;
        }
        Character[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-'};
        List<Character> list = Arrays.asList(arr);
        if (!isInteger(str)) {
            if (!list.contains(str.charAt(0))) {
                return 0;
            }
            for(int i = 0; i < str.length(); i++) {
                if (!list.contains(str.charAt(i))) {
                    str = str.substring(0, i);
                    break;
                }
            }
            if (!isInteger(str)) {
                return 0;
            }
            int start = -1, tail = -1;
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                    continue;
                } else if (str.charAt(i) == '0') {
                    if (start == -1) {
                        start = i;
                    }
                    tail = i;
                } else {
                    break;
                }
            }
            if (start == 0) {
                str = str.substring(tail + 1);
            } else if (start > 0) {
                str = str.substring(0, start) + str.substring(tail + 1);
            }
            if (str.length() == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
                return 0;
            }
        }
        if (str.length() < 10) {
            return Integer.parseInt(str);
        } else if (str.length() == 10) {
            if (str.charAt(0) == '-' || str.charAt(0) == '+') {
                return Integer.parseInt(str);
            } else {
                if (str.compareTo(Integer.toString(Integer.MAX_VALUE)) < 0) {
                    return Integer.parseInt(str);
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        } else if (str.length() == 11) {
            if (str.charAt(0) == '-') {
                if (str.compareTo(Integer.toString(Integer.MIN_VALUE)) <= 0) {
                    return Integer.parseInt(str);
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (str.charAt(0) == '+') {
                if (str.compareTo(Integer.toString(Integer.MAX_VALUE)) < 0) {
                    return Integer.parseInt(str);
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                return Integer.MAX_VALUE;
            }
        } else {
            if (str.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        String a = "-";
        System.out.println(isInteger(a));;
    }
}
