import java.util.Scanner;

public class FirstGrade {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int arr[] = new int[N];
		long dp[][] = new long[N][21];
		
		for(int i=0; i<N; i++)
		{
			arr[i] = s.nextInt();
		}
		
		dp[0][arr[0]] = 1;	//첫 번째 결과값이 될 경우의 수는 1가지.
		for(int i=1; i < N-1; i++)
			for(int j=0; j <= 20; j++)
			{
				if(dp[i-1][j] > 0)		//i-1번째 까지의 수 들로 j를 만들 수 있는 경우
				{
					if(j-arr[i] >= 0)
						dp[i][j-arr[i]] += dp[i-1][j];
					if(j+arr[i] <= 20)
						dp[i][j+arr[i]] += dp[i-1][j];
				}
			}
		
		System.out.println(dp[N-2][arr[N-1]]);
	}

}
