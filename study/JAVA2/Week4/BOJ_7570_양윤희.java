package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
	public static void main(String[] args) throws IOException {
		// 가장 긴 증가 수열 찾아야함, 그러나 증가하는 차이가 1이어야 함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int max = 0;
        int k=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i <= n; i++) {
        	k = Integer.parseInt(st.nextToken());
        	
            dp[k] = dp[k - 1] + 1; // dp[i] = i번호일때까지 연속된 증가수열의 개수
            max = Math.max(dp[k], max);
		}
		System.out.println(n - max);


	}
}