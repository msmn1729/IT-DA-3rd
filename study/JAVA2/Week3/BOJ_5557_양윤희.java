package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main7 {
/*
 *  
 * 
 *
 * */
	static int N, add, sub;
	static int[] arr;
	static long[][] dp; //dp[i][j] i는 인덱스 j는 만들 수 있는 경우의 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		String[] a = br.readLine().split(" ");
		
		for(int i=0;i<N; i++) {
			arr[i] = Integer.parseInt(a[i]);
		}
		dp = new long[N][21];
		dp[0][arr[0]] = 1; //1번째 인덱스의 경우 넣어주기
		dp();
		System.out.print(dp[N-2][arr[N-1]]); //i는 인덱스 이고 n-1번째 수는 결과값으로 써야 하므로 n-2 인덱스 참조

		}
	static public void dp() {
		
		for(int i=1; i<N-1; i++) {
			for(int j=0; j<=20; j++) {
				if(dp[i-1][j]>0) { //i-1번째 수에 대해서 d[i-1][j]>0보다 큰 값 찾기
					add = j+arr[i]; //+
					if(add <=20 ) { //0<값<20인 경우만 더하기
						dp[i][add] +=dp[i-1][j];
					}
					
					sub = j-arr[i]; //-
					if(sub>=0) { //
						dp[i][sub] += dp[i-1][j];
					}
				}
			}
		}
	}
}
