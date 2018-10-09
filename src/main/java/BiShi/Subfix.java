package main.java.BiShi;
import java.util.Scanner;

/**
 * @author: Rinchar
 * @date: 2018/9/20
 **/
public class Subfix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int num = in.nextInt();
            String[] strs = new String[num];
            for (int i = 0; i < num; i++) {
                strs[i]  = in.next();
            }
            Trie root = createTrie(strs);

            for (String s : strs) {
                String prefix = prefix(root, s);
                System.out.println(prefix);
            }
        }
    }

    public static class Trie {
        private char name;
        private int num = 1;
        private Trie[] next = new Trie[26];
        public Trie(char name) {
            this.name = name;
        }
    }

    public static Trie createTrie(String[] str) {
        Trie root = new Trie('-');
        Trie cur;
        for (String s : str) {
            cur = root;
            for (int i = 0; i < s.length(); i++) {
                int position = s.charAt(i)-'a';
                if(cur.next[position]==null) {
                    cur.next[position] = new Trie(s.charAt(i));
                }else {
                    cur.next[position].num++;
                }
                cur = cur.next[position];
            }
        }
        return root;
    }

    public static String prefix(Trie root,String str) {
        int len = 0;
        Trie cur;
        for (int i = 0; i < str.length(); i++) {
            cur = root.next[str.charAt(i)-'a'];
            if(cur==null) {
                break;
            }else if(cur.num==1) {
                len++;
                break;
            }else {
                len++;
                root = cur;
            }
        }
        return str.substring(0, len);
    }
}