package itda1105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5052_김민정 {

	static int T;
    static int N;
    static final int NUMS = 10;
 
    static class Trie {
        boolean isEndWord;
        Trie children[];
 
        public Trie() {
            isEndWord = false;
            children = new Trie[NUMS];
            for (int i = 0; i < NUMS; ++i)
                children[i] = null;
        }
    }
 
    static Trie root;
 
    static void insert(String key) {
        Trie curTrie = root;
        int length = key.length();
        int level;
        int index;
 
        for (level = 0; level < length; ++level) {
            index = key.charAt(level) - '0';
            if (curTrie.children[index] == null) {
                curTrie.children[index] = new Trie();
            }
            curTrie = curTrie.children[index];
        }
        curTrie.isEndWord = true;
    }
 
    static boolean available(String key) {
        Trie curTrie = root;
        int length = key.length();
        int level;
        int index;
 
        for (level = 0; level < length; ++level) {
            index = key.charAt(level) - '0';
            if (curTrie.isEndWord)
                return false;
            curTrie = curTrie.children[index];
        }
 
        return true;
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            root = new Trie();
            String[] str = new String[N];
            for (int n = 0; n < N; n++) {
                str[n] = br.readLine();
                insert(str[n]);
            }
 
            boolean ans = true;
 
            for (int n = 0; n < N; n++) {
                if (!available(str[n])) {
                    ans = false;
                    break;
                }
            }
            
            if(ans)
                sb.append("YES\n");
            else
                sb.append("NO\n");
 
        }
        System.out.print(sb.toString());
    }

}
