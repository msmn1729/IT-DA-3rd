import java.util.*;

public class 4811_al_yag {
	
	static long dp [][];

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		//long dp [][] = new long[2*N+1][2*N+1];
		//long dp [][] = new long[N+1][N+1];
		
		dp = new long[2*N+1][2*N+1];
		
		/*for(int W = 0; W <= N; W++) {
			
			for(int H = 0; H <= N; H++) {
				
				if(W == 0) {
					if(dp[W][H] == 0)
						dp[W][H] = 1;
					continue;
				}
				
				if(W > 0 && H < 1) {
					dp[W][H] = dp[W][H] + dp[W-1][H+1];
					continue;
				}
				
				System.out.println(W + " " + H);
				dp[W][H] = dp[W][H-1] + dp[W-1][H+1];
			}
		}*/
		
		
		System.out.println(dp_f(N, 0));
		
		//System.out.println(dp[N][0]);
	}
	
	public static long dp_f(int W, int H) {
		
		if(W > 0) {
			if(dp[W][H] != 0)
				return dp[W][H];
		}
		
		if(W == 0) {
			dp[W][H] = 1;
			return 1;
		}
		
		else {
			
			long tmp = 0;
			
			tmp = tmp + dp_f(W-1, H+1);
			
			if(H >= 1)
				tmp = tmp + dp_f(W, H-1);
			/*if(W > 0 && H < 1) 
				dp[W][H] = dp_f(W-1, H+1);
				
			
			else 
				dp[W][H] = dp[W][H-1] + dp[W-1][H+1];*/
			
			dp[W][H] = tmp;
			
			return dp[W][H];
		}
		
		//return dp[W][H];
			
	}

}
