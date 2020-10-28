import java.util.*;

public class 강채민_4811_알약 {
	
	static long dp [][];

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//테스트 케이스를 생각을 안해서 틀린 문제였다.
		
		while(true) {
			
			int N = input.nextInt();
			
			if(N == 0)
				return;
			
			dp = new long[2*N+1][2*N+1];
			
			
			System.out.println(dp_f(N, 0));
		}
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
			
			dp[W][H] = tmp;
			
			return dp[W][H];
		}
			
	}

}
