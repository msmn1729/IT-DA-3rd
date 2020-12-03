import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_김영민 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int [] T = new int [N+2];
		int [] P = new int [N+2]; 
		int [] dp = new int [N+2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken()); //소요시간
			P[i] = Integer.parseInt(st.nextToken()); //이익
		}
		
		for(int i=N; i>0; i--) {
			if(i+T[i]-1>N) dp[i] = dp[i+1]; //N+1일째에는회사에없기때문에
			else dp[i] = Math.max(dp[i+1], P[i]+dp[i+T[i]]);
		}
		System.out.print(dp[1]);
	}
}
