package BOJ;

import java.io.IOException;
import java.util.Scanner;

public class Main10 {
	
	static int N, M, K, num, x, y;
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
		int num =0;
		
		dp = new int [N+1][M+1];
		for(int i=1; i<=N; i++) {//n,m만큼 dp배열에 수를 넣어준다.
			for(int j=1;j<=M; j++) {
				dp[i][j] =num++;
				if(num==K) { //k의 위치 찾아주기
					x = i;
					y = j;
				}
			}
		}
		if(K==0) {
			System.out.println(dp(N,M));
		}
		else {
			System.out.println(dp(x,y) * dp(N - x+1, M-y+1));
		}
	}
	
	static int dp(int N, int M) { 
		if(N == 1 ) return 1;
		if(M == 1 ) return 1;
		return dp[N][M] = dp(N-1, M) + dp(N, M-1); //(n,m)까지 가기 위해서는 (n-1,m) (n,m-1)까지 가야한다.
	}
}
