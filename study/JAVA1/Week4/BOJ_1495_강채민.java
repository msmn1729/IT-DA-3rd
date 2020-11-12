import java.util.*;

public class 1495_ㅊㅁ {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt(); // 곡의 개수
		int S = input.nextInt(); // 시작 볼륨
		int M = input.nextInt(); // 최대 볼륨
		
		int V[] = new int[N]; // 리스트 V
		int dp[][] = new int[N][M+1];
		
		for(int n = 0; n < N; n++)
			V[n] = input.nextInt();
	
		if(S + V[0] >= 0 && S + V[0] <= M) 
			dp[0][S+V[0]] = 1;
		
		if(S - V[0] >= 0 && S - V[0] <= M) 
			dp[0][S-V[0]] = 1;
		
		for(int i = 1; i < N; i++) {
			
			for(int j = 0; j <= M; j++) {
				
				if(dp[i-1][j] == 1) {
					
					if(j + V[i] >= 0 && j + V[i] <= M) 
						dp[i][j + V[i]] = 1;
					
					if(j - V[i] >= 0 && j - V[i] <= M) 
						dp[i][j - V[i]] = 1;
				}
			}
		}
		
		int max = -1;
		
		for(int m = M; m >= 0; m--) {
			
			if(dp[N-1][m] == 1) {
				max = m;
				break;
			}
		}
		
		System.out.println(max);
		
	}

}
