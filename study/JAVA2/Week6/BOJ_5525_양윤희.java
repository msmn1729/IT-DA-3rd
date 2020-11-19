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

//////시간초과!!!!!!!!!!!!/////////
class Main10 {
	static String p = "I";
	static char[] s;
	static int n,m, cnt;
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		m = Integer.parseInt(sc.nextLine());
		s =  sc.nextLine().toCharArray();
		String str = new String(s);
		for(int i=0; i<n; i++) {
			p+="OI"; //N만큼 OI추가
		}
		int k = p.length();
		for(int i=0; i<m-p.length(); i++, k++) {
			if(str.substring(i, k).equals(p)) { //P랑 같은 게 있으면 CNT++
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}