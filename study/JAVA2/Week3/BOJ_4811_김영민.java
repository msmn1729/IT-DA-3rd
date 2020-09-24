import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ_4811_김영민 {

	static long [][]dp = new long[31][31];

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			bw.write(dp(N,0)+"\n");
		}
		
		//for(int i=0; i<=30; i++) {
		//	for(int j=0; j<=30; j++) {
		//	System.out.print(dp[i][j]+" ");
		//	}
		//	System.out.println();
		//}
		
		
		bw.flush();
	}
	
	static long dp(int W, int H) {
		if(dp[W][H]>0) return dp[W][H];
		if(W==0 && H ==0) return 1; // 다 먹은 경우 count++
		if(W>0) dp[W][H] += dp(W-1, H+1); //한 조각을 꺼내는 경우
		if(H>0) dp[W][H] += dp(W, H-1); //반 조각을 꺼내는 경우

		return dp[W][H];
	}
}

/*
dp(3,0) : dp[3][0] += dp(2,1); -> 5
dp(2,1) : dp[2][1] += dp(1,2); return dp[1][2] 3 / dp[2][1] += dp[2][0]; return dp[2][0] 2 -> 5
dp(1,2) : dp[1][2] += dp(0,3); return dp[0][3] 1 / dp[1][2] += dp[1][1]; return dp[1][1] -> 3
dp(0,3) : dp[0][3] += dp(0,2); return dp[0][2] 1 
dp(0,2) : dp[0][2] += dp(0,1); return dp[0][1] 1 
dp(0,1) : dp[0][1] += dp(0,0) dp(0,0) : return 1;

dp(1,1) : dp[1][1] += d(0,2) return dp[0][2] 1 / dp[1][1] += dp(1,0); return dp[1][0] 1 -> 2
d(0,2) = return dp[0][2];
dp(1,0) : dp[1][0] += dp(0,1); return dp[0][1] 1

dp(2,0) : dp[2][0] += dp[1][1]; return dp[1][1] 2
*/