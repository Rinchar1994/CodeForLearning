package main.java.LeetCode.LeetCode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rinchar on 2017/11/9.
 */
public class _68_TextJustification {
    //68. Text Justification (Hard) 7.71%
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> re = new ArrayList<>();
        int begin = 0, end = 0, sumLen = 0;
        while (begin < words.length) {
            if (end >= words.length) {
                String temp = "";
                for (int i = begin; i < end - 1; i++) temp += words[i] + " ";
                temp += words[end - 1];
                int lenSpace = maxWidth - temp.length();
                for (int i = 0; i < lenSpace; i++) temp += " ";
                re.add(temp);
                begin = end;
            } else if (sumLen + words[end].length() + end - begin <= maxWidth) {
                sumLen += words[end].length();
                end++;
            } else {
                String temp = "";
                try {
                    int spaceAveLen = (maxWidth - sumLen) / (end - 1 - begin);
                    String spaceStr = "";
                    for (int i = 0; i < spaceAveLen; i++) spaceStr += " ";
                    int numLonger = (maxWidth - sumLen) % (end - 1 - begin);
                    for (int i = begin; i < end - 1; i++) {
                        if (i < begin + numLonger) temp += words[i] + spaceStr + " ";
                        else temp += words[i] + spaceStr;
                    }
                    temp += words[end - 1];
                } catch (ArithmeticException e) {
                    temp = words[begin];
                    for (int i = sumLen + 1; i <= maxWidth; i++) temp += " ";
                }
                begin = end;
                sumLen = 0;
                re.add(temp);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        String[] a = {"This", "is", "an", "justification.", "example", "of", "text"};
        System.out.println(fullJustify(a, 16));
    }
}
