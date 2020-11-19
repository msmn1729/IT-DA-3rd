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

///15810
class Main10 {

	static int sum, cnt;
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] A = new int[N];
		 st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		cnt=A[0];
		sum=1;
		while(true) {
			for(int i=0; i<N; i++) {
				if(sum==M) {System.out.println(cnt); return;}
				if(cnt % A[i]==0) {
					sum++;
				}
			}
			cnt++;
		}
	}
}