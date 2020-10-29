import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_7570_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int [] dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int j = Integer.parseInt(st.nextToken());
			dp[j] = dp[j-1]+1; // 연속된 값에 대한 부분수열 만들기
		}
		
		Arrays.sort(dp); // sort시키고 max값 찾기
		System.out.print(N-dp[N]); // 전체 중에서 가장 큰 부분수열의 길이 뺀 값
	}
}
