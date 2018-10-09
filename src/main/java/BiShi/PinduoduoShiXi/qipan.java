package main.java.BiShi.PinduoduoShiXi;

import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/8/30
 **/
public class qipan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] a_dup = a.split(" ");
        int N = Integer.valueOf(a_dup[0]), M = Integer.valueOf(a_dup[1]);
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String b = in.nextLine();
            char[] temp = b.trim().toCharArray();
            map[i] = temp;
        }
        for (int i = 0; i < M; i++) {
            int num_o = 0;
            int j = 0;
            while (j < N) {
                for (; j < N; j++) {
                    if(map[j][i] == 'o'){
                        num_o++;
                        map[j][i] = '.';
                    } else if (map[j][i] == 'x') {
                        for (int k = j - 1; k >= j - num_o; k--) {
                            map[k][i] = 'o';
                        }
                        num_o = 0;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
