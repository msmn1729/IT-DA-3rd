import java.util.*;

public class 5557_Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int Number [] = new int [N];
		
		for(int n = 0; n < N; n++) // 숫자들을 다 담아준다. 8 2 3 ... 이렇게
			Number[n] = input.nextInt();
		
		/**
		 * 숫자들을 다 담아준 뒤에 dp를 돌면서 확인한다.
		 * dp[0번째 숫자까지로 만들 수 있는][숫자]
		 */
		
		//int dp [][] = new int [N][21];
		long dp [][] = new long [N][21];
		
		dp[0][Number[0]] = 1; // 0번째 숫자로 만들 수 있는 숫자를 1로 설정해두기.
		
		for(int i = 1; i < N - 1; i++) { // 1부터 맨 마지막 숫자 전 까지 돌도록 한다.
			
			for(int j = 0; j <= 20; j++) { // 만들어질 수 있는 숫자는 0부터 20까지 이다.
				
				if(dp[i-1][j] > 0) { // 그 전의 숫자로 만들어질 수 있는 숫자가 있다면
					
					int num = 0;
					
					/**
					 * 8 2 3 ... 이렇게된 숫자라고 가정하자.
					 * i가 1일때 dp[0][8] > 0을 만족하게 되고, 이때의 i는 1, j는 8 이다.
					 * 8+2와 8-2를 수행해야한다.
					 * 2는 Number배열 i번째 숫자이다. 따라서
					 * 8(j) + 2(Number[i]) 이렇게 수행.
					 * -도 똑같이.
					 */
					num = j + Number[i]; // i가 0일때
					
					if(num >= 0 && num <= 20) // 범위 안에 있을 때.
						dp[i][num] = dp[i][num] + dp[i-1][j]; 
					// dp[1][10]이란 1번째 숫자를 가지고 만들 수 있는 수가 11인 경우는 원래 경우의 수에다가 전의 경우의 수를 더한다.
					
					num = j - Number[i]; // 마찬가지로 뺄샘 수행.
					
					if(num >= 0 && num <= 20) // 범위 안에 있을 때.
						dp[i][num] = dp[i][num] + dp[i-1][j]; 
				}
			}
		}
		
		//다 돌았으면 결국 내가 원하는 수는 dp[맨 마지막 숫자 전까지로 만들 수 있는][맨 마지막 숫자.]
		System.out.println(dp[N-2][Number[N-1]]);
	}

}
