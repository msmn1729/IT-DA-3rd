import java.util.*;

public class 2407_nCm {
	
	static int dp[][] = new int [101][101];

	public static void main(String[] args) {
		
		/**
		 * ¾ÈµÊ ¤Ð
		 */

		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int M = input.nextInt();
		
		System.out.println(dp_f(N, M));
		
	}
	
public static int dp_f(int n, int k) {
		
		if(k > n || k < 0)
			dp[n][k] = 0;
		
		else {
			dp[n][k] = dp_f(n-1, k-1) + dp_f(n-1, k);
		}
		
		return dp[n][k];
	}

}
