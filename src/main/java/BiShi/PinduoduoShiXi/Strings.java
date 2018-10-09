package main.java.BiShi.PinduoduoShiXi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/8/30
 **/
public class Strings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] a_dup = a.split(" ");
        int M = Integer.valueOf(a_dup[0]), L = Integer.valueOf(a_dup[1]);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            stringList.add(in.nextLine());
        }
        if(stringList.size() == 0) System.out.println("-");
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < L; i++) {
            char ch = stringList.get(0).charAt(i);
            for (int j = 0; j < M; j++) {
                if(ch > stringList.get(j).charAt(i)) ch = stringList.get(j).charAt(i);
            }
            temp.append(ch);
        }
        String re = "";
        for (int j = L - 1; j >= 0; j--) {
            for (int i = 0; i < M; i++) {
                temp.replace(j, j + 1, stringList.get(i).substring(j, j + 1));
                if (!stringList.contains(temp.toString())) {
                    if (re == "") {
                        re = temp.toString();
                    } else {
                        if (re.compareTo(temp.toString()) > 1) {
                            re = temp.toString();
                        }
                    }
                }
            }
            if (re != "") {
                System.out.println(re);
                break;
            }
        }
        if (re == "") {
            System.out.println("-");
        }
    }
}
