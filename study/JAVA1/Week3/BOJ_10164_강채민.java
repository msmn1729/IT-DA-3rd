import java.util.*;

public class 10164_강채민 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int M = input.nextInt();

		int K = input.nextInt();
		
		int grid [][] = new int [N][M];
		
		int dp [][] = new int [N+1][M+1];
		
		//dp[0][0] = 1;
		
		/**
		 * https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=221012382627&proxyReferer=https:%2F%2Fwww.google.com%2F
		 * 참고해서 풀었다. 
		 * 
		 * 격자를 더 넓혀서 푸는거랑 기존에 1로 만들어 주는걸..까먹었다.. ㅜ
		 * 
		 * 그리고 점화식을 잘 해결을 못했었다.
		 */
		
		dp[0][1] = 1;
		
		for(int i = 1; i <= N; i++) {
			
			for(int j = 1; j <= M; j++) {
				
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		int answer = 0;
		
		if(K > 0) {
			
			int before_K_X = 0;
			
			if(K % M > 0) 
				before_K_X = K / M + 1;
			
			else
				before_K_X = K / M; // M의 배수인거는 몫이 하나 더 크기 때문에 상관 없다.
			
			int before_K_Y = K - (before_K_X - 1) * M; // 이게 점화식이다...ㅎ
			
			int after_K_X = N - before_K_X + 1;
			int after_K_Y = M - before_K_Y + 1;
			
			answer = dp[before_K_X][before_K_Y] * dp[after_K_X][after_K_Y];
		}
		
		else {
			answer = dp[N][M];
		}
		
		System.out.println(answer);
		
	}

}
