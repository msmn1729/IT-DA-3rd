package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
//11497
public class Main11 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int tree[] = new int[n];
			for (int i = 0; i < n; i++) {
				tree[i] = sc.nextInt();
			}
			Arrays.sort(tree);
			int res[] = new int[n];
			int m = n/2;
			res[m] = tree[0];
			int j=0;
			for(int i=0; i<m; i++, j=j+2) {
				res[m-i-1] = tree[j+1];
				if(j+2>n-1) {continue;}
				res[m+i+1] = tree[j+2];
			}
			if(res[n-1]==0) res[n-1] = tree[n-1];
			int max =0;
			for(int i=0; i<n; i++) {
				if(i==n-1) {
					if(max < Math.abs((res[i] - res[0]))) {
						max =  Math.abs((res[i] - res[0]));
						}
					}
				else if(max < Math.abs((res[i] - res[i+1]))) {
					max =  Math.abs((res[i] - res[i+1]));
				}
			}
			System.out.println(max);
		}
	}
}