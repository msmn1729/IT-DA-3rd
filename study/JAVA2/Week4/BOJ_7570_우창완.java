import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7570_우창완 {
//줄 세우기 문제는 Lis 를 찾는 것과같다(가장 긴 증가하는 연속수열 찾기)
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] temp=br.readLine().split(" ");
		int n=Integer.parseInt(temp[0]);
		temp=br.readLine().split(" ");
		int[]dp=new int[n+1];
		//n=1000000이므로 n^2으로는 안풀린다 따라서 입력받자마자 풀수 있게끔 코드 정리
		for(int i=0; i<n; i++)	{
			int lis=Integer.parseInt(temp[i]);
			dp[lis]=dp[lis-1]+1;
		}
		Arrays.sort(dp);
		System.out.println(n-dp[n]);
	}
}
