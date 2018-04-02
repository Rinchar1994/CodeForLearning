package main.java.LeetCode.LeetCode2;

/**
 * Created by Rinchar on 2017/11/7.
 */
public class _65_ValidNumber {
    //65. Valid Number (Hard) 38.23%
    public static boolean isNumber(String s) {
        int state = 1;
        for (char Char : s.toCharArray()) {
            switch (state) {
                case 1:
                    if (Char == ' ') ;
                    else if (Char == '+' || Char == '-') state = 2;
                    else if (Char == '.') state = 4;
                    else if (Char >= '0' && Char <= '9') state = 3;
                    else return false;
                    break;
                case 2:
                    if (Char == '.') state = 4;
                    else if (Char >= '0' && Char <= '9') state = 3;
                    else return false;
                    break;
                case 3:
                    if (Char == ' ') state = 9;
                    else if (Char == 'e') state = 6;
                    else if (Char == '.') state = 5;
                    else if (Char >= '0' && Char <= '9') ;
                    else return false;
                    break;
                case 4:
                    if (Char >= '0' && Char <= '9') state = 5;
                    else return false;
                    break;
                case 5:
                    if (Char >= '0' && Char <= '9') ;
                    else if (Char == 'e') state = 6;
                    else if (Char == ' ') state = 9;
                    else return false;
                    break;
                case 6:
                    if (Char == '-' || Char == '+') state = 7;
                    else if (Char >= '0' && Char <= '9') state = 8;
                    else return false;
                    break;
                case 7:
                    if (Char >= '0' && Char <= '9') state = 8;
                    else return false;
                    break;
                case 8:
                    if (Char >= '0' && Char <= '9') ;
                    else if (Char == ' ') state = 9;
                    else return false;
                    break;
                case 9:
                    if (Char == ' ') ;
                    else return false;
                    break;
                default:
                    break;
            }
        }
        if (state == 3 || state == 5 || state == 8 || state == 9) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("2e10"));
    }
}
