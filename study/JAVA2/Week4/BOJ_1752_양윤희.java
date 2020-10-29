package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main11 {
	public static int n, s, m, vol[], dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line[] = in.readLine().split(" ");
		n = Integer.parseInt(line[0]); //n개의 곡
		s = Integer.parseInt(line[1]);//시작볼륨
		m = Integer.parseInt(line[2]);//볼륨의 최댓값
		vol = new int[n];
		dp = new int[n+1][m+1]; //이차원 배열에 -와 +값이 가능한지 여부 넣기
		line = in.readLine().split(" ");
		for(int i=0;i<n;i++) vol[i] = Integer.parseInt(line[i]);//변주할 볼륨
		
		//첫번째 곡은 첫번쨰 볼륨을 이용해 먼저 계산
		if(s+vol[0] <= m) dp[0][s+vol[0]] = 1;
		if(s-vol[0] >= 0) dp[0][s-vol[0]] = 1;		
		
		for(int i=1; i<n; i++) {
			int cnt =0;
			for(int j=0; j<=m; j++) {
				if(dp[i-1][j]==1) {
					if(j+vol[i]<=m) dp[i][j+vol[i]] =1;
					if(j-vol[i]>=0) dp[i][j-vol[i]] =1;
					cnt++;
				}
			}
			if(cnt==0) {
				System.out.println("-1");

			}
		}
		
	for(int i=m; i>=0; i--) {
		if(dp[n-1][i]==1) {
			System.out.println(i);
			break;
			}
		}
	}
}