package itda_2020;
import java.util.*;
import java.io.*;

public class BOJ_4811_박소현 {
	static int N;
	static long result = 0 ;
	static long dp [];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 dp = new long[31];
		 dp[0] = 1;
		 dp[1] = 1;
		 dp[2] = 2;
		 
		 dp();
		 
		 while (true) {
			 	N = Integer.parseInt(br.readLine());
			 	if(N==0) break;
	            bw.write(dp[N]+"\n");
	     }
		 bw.close();
		br.close();
	}
	
	static void dp() {
			
			for (int i = 3; i < 31; i ++ ) {
				result = 0;
				for (int j = 0; j < i ; j++) {
					result = result + dp[j]*dp[i-1-j]; 
				}
				dp[i] = result;
			}
	}
}
