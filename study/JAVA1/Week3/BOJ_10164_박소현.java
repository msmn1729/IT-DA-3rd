package itda_2020;
import java.util.*;
import java.io.*;

public class BOJ_10164_박소현 {
	static int N,M,K;
	static int dp[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
		dp = new int[15][15];
		dp[0][0] = 1;
 		if (K == 0) {
 			dp(0,0,N-1,M-1);
		     
			bw.write(dp[N-1][M-1]+"");
		}
		
		else {
			dp(0,0,K/M,K%M-1);
			
			int tmp = dp[K/M][K%M-1];
			dp[K/M][K%M-1] =1;
			dp(K/M,K%M-1,N-1,M-1);
		   
		    bw.write(dp[N-1][M-1]*tmp+"");
		}
		 bw.flush();
	     br.close();
	     bw.close();
	}

	static void dp(int startX, int startY,int endX,int endY) {
		for (int i = startX; i <= endX ; i++) {
			for (int j = startY ; j <= endY ; j++ ) {
				if (i<endX) {
					dp[i+1][j] = dp[i+1][j]+dp[i][j];
				}
				if (j < endY)  {
					dp[i][j+1] = dp[i][j+1]+dp[i][j];
				}
			}
		}
	}
}


//만약 동그라미칸이 있다면 
//그 칸을 반드시 지나야 하니까 그까지 간다음 -> 다시 끝칸까지 가는 경우로 계산 

/*
 * if (i==endX&&j!=endY) {
					dp[i][j+1] = dp[i][j+1]+dp[i][j];
				}
				if (i!=endX&&j==endY) {
					dp[i+1][j] = dp[i+1][j]+dp[i][j];
				}
				if (i+1 <endX && j+1 < endY)  {
					dp[i+1][j] = dp[i+1][j]+dp[i][j];
					dp[i][j+1] = dp[i][j+1]+dp[i][j];
				}
				
				*/


/*
for (int k = 0; k < N; k++) {
for (int j = 0; j < M ; j++) {
	bw.write(dp[k][j]+" ");
	}
	bw.write("\n");
}
for (int k = 0; k < N; k++) {
for (int j = 0; j < M ; j++) {
	bw.write(dp[k][j]+" ");
	}
	bw.write("\n");
}

for (int k = 0; k < N ; k++) {
for (int j = 0; j < M ; j++) {
	bw.write(dp[k][j]+" ");
	}
bw.write("\n");
}

*/