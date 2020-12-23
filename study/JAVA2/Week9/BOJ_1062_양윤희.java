package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

///1062
class Main10 {
	static String[] word;
	static int dat[];
	static char res[][];
	public static void main(String[] args) throws IOException { 
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        word = new String[3];
        for(int i=0; i<n; i++) {
        	word[i] = sc.next();
        }
        Arrays.sort(word, Comparator.comparingInt(String::length));
        dat = new int[200];
        res = new char[3][20];
        for(int i=0; i<n; i++) {
        	word[i] = word[i].substring(4, word[i].length()-4);
        	System.out.println(word[i]);
        }
        for(int i=0; i<n; i++) {
        	
        }
	}
}