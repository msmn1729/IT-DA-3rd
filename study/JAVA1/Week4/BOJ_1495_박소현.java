package itda_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1495_박소현 {
	static int numbers[];
	static boolean[][] dp;
	static int N,M,S;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N+1];
		dp = new boolean[N+1][M+1];
		int k = 1;
		while(st.hasMoreTokens()) {
			numbers[k]= Integer.parseInt(st.nextToken());
			k++;
		}
		// TODO Auto-generated method stub
		
		for (int i = 0; i<N;i++) {
			for(int j=0;j<M;j++) {
				dp[N][M]= false;
			}
		}
		
		dp[0][S] = true;
		recur(S);
		System.out.println(findMax());
	}
	
	static void recur(int preNum) {
		for (int i=1;i<=N;i++) {
			//int tmp = numbers[i-1];
			for (int j=0;j<=M;j++) {
				if(dp[i-1][j]==true) {
					if(0<=j-numbers[i]){
						dp[i][j-numbers[i]]=true;
					}
					if(j+numbers[i]<=M){
						dp[i][j+numbers[i]]=true;
					}
				}
				else continue;
			}
		}
		
		
	}
	
	static int findMax() {
		int Max = 0;
		for (int i=0;i<M+1;i++) {
			if(dp[N][i]==true) Max = i;
			System.out.println(Max);
			System.out.println(N);
		}
		return Max;
	}

}
